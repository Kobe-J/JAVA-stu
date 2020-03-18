package appium_xuexi;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 抖音爬虫
 * appium  selenium  java
 * @author yxl
 * @since 2020/1/6
 */
public class DouYinCrawlerThread extends Thread {

    public static Integer PAGE_LIMIT = 20; // 翻页限制，20页

    private static Logger logger = Logger.getLogger(DouYinCrawlerThread.class);
    private static List<String> keyList = new ArrayList<>();
    private static Integer keyIndex = 0; // 当前需要进行搜索的关键词
    private static boolean noReset = true;

    static {
        keyList.add("吴亦凡");
        keyList.add("王北车");
        keyList.add("冯提莫");
        keyList.add("姚希龙");
        keyList.add("小智");
    }

    public DouYinCrawlerThread(boolean noReset) {
        this.setName("抖音视频采集线程");
        DouYinCrawlerThread.noReset = noReset;
    }

    @Override
    public void run() {
        logger.info("启动：" + this.getName());
        while (true) {
            Date startTime = new Date();
            try {
                keyIndex = 0;
                startCrawler();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            long consumeTime = new Date().getTime() - startTime.getTime();
            long sleepTime = 60 * 60 * 1000 - consumeTime;
            if (sleepTime <= 0) {
                sleepTime = (20 + new Random().nextInt(40)) * 60 * 1000;
            }

            if (!noReset) {
                noReset = true; // 默认从第二次开始，不需要清空缓存
            }
            logger.info("本轮查询结束，共用时：" + consumeTime/(60*1000) + "分钟，距下一轮查询开始需睡眠：" + sleepTime/(60*1000) + "分钟");
            sleepTime(sleepTime); // 1h一次完整搜索
        }
    }

    /**
     * 启动爬虫
     */
    private static void startCrawler() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "CLB0218523001219"); //
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion","9");
        desiredCapabilities.setCapability("appPackage","com.ss.android.ugc.aweme");
        desiredCapabilities.setCapability("appActivity",".main.MainActivity");
        desiredCapabilities.setCapability("unicodeKeyboard", true);
        desiredCapabilities.setCapability("resetKeyboard", true); // 是否重置输入法到原状态
        desiredCapabilities.setCapability("noReset", noReset);
        logger.info(noReset ? "本次启动不清空缓存" : "本次启动清空缓存");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        boolean fail = false;
        do {
            try {
                logger.info("启动抖音APP中！");
                startApp(desiredCapabilities, url);
                fail = false;
            } catch (Exception ex) {
                fail = true;
                logger.info("系统异常，此次中断的关键词为：" + keyList.get(keyIndex)+ "，重启服务");
                ex.printStackTrace();
            }
        } while (fail) ;
    }

    /**
     * 启动抖音APP
     * @param desiredCapabilities
     * @param url
     * @throws Exception
     */
    private static void startApp(DesiredCapabilities desiredCapabilities, URL url) throws Exception {
        AndroidDriver webDriver = new AndroidDriver(url, desiredCapabilities);
        Thread.sleep(8*1000);
        String pageSource = webDriver.getPageSource();
        System.out.println(pageSource);
        // 判定是否存在需要关闭的弹框
        while (needToCheckAndClick(pageSource)) {
            exCheckAndReset(webDriver);
            Thread.sleep(5 * 1000);
        }

        //点击屏幕进入
        Thread.sleep(3*1000);
        logger.info("点击屏幕");
        click(500, 1000, webDriver);

        if (!noReset) {
            // 如果重置了缓存，则需要重新登录
            logger.info("缓存被重置，需要重新登录");
            try {
                login(webDriver);
            } catch (Exception ex) {
                logger.info("头条授权登录失败");
                getScreenShot(webDriver);
                ex.printStackTrace();
                throw ex; // 登录失败，抛出
            }

            Thread.sleep(5 * 1000);//延时处理
            pageSource = webDriver.getPageSource();
            // 登录后，再次判定是否存在需要关闭的弹框
            while (needToCheckAndClick(pageSource)) {
                exCheckAndReset(webDriver);
                Thread.sleep(5 * 1000);//延时处理
            }
        }


        // 点击进入搜索页
        Thread.sleep(3*1000);
        logger.info("点击进入搜索页");
        click(1020, 168, webDriver);

        // 开始搜索
        int time = 0;
        int successTime = 0;
        boolean isNew = true;
        for (; keyIndex < keyList.size(); keyIndex++) {
            time++;
            String keywords = keyList.get(keyIndex);
            logger.info((time) + ": 开始查询，查询关键词：" + keywords);
            try {
                boolean res = search(webDriver, keywords, isNew); //
                if (res) {
                    successTime++;
                }
                if (isNew) {
                    isNew = false; // 设为false
                }
            } catch (Exception ex) {
                logger.info("查询出错：");
                getScreenShot(webDriver); // 截图
                throw ex; // 出错了，返回
            }
            Thread.sleep(5 * 1000);
        }
        logger.info("关闭APP");
        webDriver.closeApp();
        Thread.sleep(10 * 1000);
        logger.info("执行查询" + (time) + "次，成功" + successTime + "次，失败" + (time - successTime) + "次");
    }

    /**
     * 通过头条进行登录
     * @param webDriver
     * @throws Exception
     */
    public static void login(AndroidDriver webDriver) throws Exception {
        // 登录
        Thread.sleep(5 * 1000);
        logger.info("点击登录");
        click(650, 1240, webDriver);

        // 点击头条登录
        Thread.sleep(5 * 1000);
        if (!webDriver.getPageSource().contains("密码登录")) {
            Thread.sleep(5 * 1000);
        }
        logger.info("选择头条登录");
        click(215, 580, webDriver);

        // 点击头条授权登录
        Thread.sleep(10 * 1000);
        logger.info("点击头条授权登录");
        click(340, 650, webDriver);

        // 选择跳过绑定手机号
        Thread.sleep(10 * 1000);
        logger.info("选择跳过绑定手机号");
        click(670, 75, webDriver);
    }

    /**
     * 搜索
     * @param webDriver
     * @throws InterruptedException
     */
    private static boolean search(AndroidDriver webDriver, String keywords, boolean isNew) throws Exception {

        if (!isNew) {
            Thread.sleep(3*1000);

            // 点击输入框
            click(320, 80, webDriver);

            logger.info("输入关键词");
            WebElement editElement = webDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.EditText"));

            editElement.clear(); // 清空输入框内容；
            editElement.click();
            editElement.sendKeys(keywords);
        } else {
            Thread.sleep(3*1000);

            webDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]"))
                .click();

            Thread.sleep(3 * 1000);
            logger.info("输入关键词");
            webDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.EditText"))
                .sendKeys(keywords); // 输入关键词
        }

        Thread.sleep(5*1000);
        logger.info("点击搜索");
        click(670, 70, webDriver); // 点击搜索

        if (isSearchNull(webDriver)) {
            return false;
        }

        Thread.sleep(3*1000);
        // 点击选择视频
        webDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]"))
            .click();


        int width = webDriver.manage().window().getSize().width;
        int height = webDriver.manage().window().getSize().height;

                int i = 0; // 翻页次数
                int swipeFailNum = 0; // 翻页失败次数
                while (swipeFailNum < 1) {
                    if (i >= PAGE_LIMIT) {
                logger.info("翻页达到限制，" + PAGE_LIMIT + "页，结束翻页");
                break;
            }
            logger.info("开始翻页：" + (i+1));
            try {
                Thread.sleep( 2 * 1000);
                swipe(webDriver, width/2, (int)(height * 0.75), width/2, (int)(height/3));
                swipe(webDriver, width/2, (int)(height * 0.75), width/2, (int)(height/3)); // 滑动两次
                logger.info("翻页成功");
            } catch (Exception ex) {
                logger.info("翻页失败");
                swipeFailNum++;
                ex.printStackTrace();
            } finally {
                i++;
            }
            // 查看是否为最后一页
            String source = webDriver.getPageSource();
            if (source.contains("没有搜索到相关")) {
                getScreenShot(webDriver); // 截图
                logger.info(source);
                logger.info("没有搜索到相关的内容");
                break;
            }
            if (source.contains("没有更多")) {
                logger.info(source);
                logger.info("已达到最后一页，没有更多数据了");
                break;
            }
            try {
                viewAndReturn(webDriver); // 随机点击视频进行查看，并返回
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("点击视频查看报错");
            }
        }
        logger.info("本次视频查询成功");
        return true;
    }

    /**
     * 随机查看当前页的视频，随机等待时间后，返回
     */
    private static void viewAndReturn(AndroidDriver driver) throws Exception {
        Thread.sleep(5 * 1000);
        logger.info("点击查看视频");
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        logger.info("width = " + width + ", height = " + height);
        int randomX = width/2 + (new Random().nextBoolean() ? new Random().nextInt(width/4) : - new Random().nextInt(width/4));
        int randomY = height/2 + (new Random().nextBoolean() ? new Random().nextInt(height/4) : - new Random().nextInt(height/4));
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(randomX, randomY));
        action.perform();

        logger.info("randomX = " + randomX + ", randomY = " + randomY);

        Thread.sleep(3 * 1000);
        String resource = driver.getPageSource();
        if (resource != null && resource.contains("视频") && resource.contains("综合")) {
            logger.info("打开视频失败，返回");
            return;
        }
        int sleepTime = 3 + new Random().nextInt(9);
        logger.info("睡眠" + sleepTime + "秒");
        Thread.sleep(sleepTime * 1000);

        logger.info("查看完毕，返回");
        action.tap(PointOption.point(35, 80));
        action.perform();
        action.release();
    }

    /**
     * 点击坐标
     * @param x
     * @param y
     * @param driver
     */
    private static void click(int x, int y, AndroidDriver driver) {
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x, y));
        action.perform();
        action.release();
    }
    /**
     * 滑动
     * @param driver
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     */
    private static void swipe(AndroidDriver driver, int fromX, int fromY, int toX, int toY) {
        Duration duration = Duration.ofMillis(800);
        TouchAction action = new TouchAction(driver)
            .press(PointOption.point(fromX, fromY))
            .waitAction(WaitOptions.waitOptions(duration))
            .moveTo(PointOption.point(toX, toY)).release();
        action.perform();
        action.release();
    }

    /**
     * 获取屏幕截图
     * @param driver
     */
    private static void getScreenShot(AndroidDriver driver) {
        File img = driver.getScreenshotAs(OutputType.FILE);
        if (img != null && img.exists()) {
            File file = new File(new Date().getTime() + "." + img.getName().split("\\.")[1]);
            try {
                FileUtils.copyFile(img, file);
                img.delete();
                logger.info("屏幕截图：" + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 检查搜索结果是否为空
     * @param driver
     * @return
     */
    private static boolean isSearchNull(AndroidDriver driver) {
        String resource = driver.getPageSource();
        return resource != null && resource.contains("搜索结果为空");
    }

    /**
     * APP运行时的弹窗处理
     * @param driver
     */
    private static void exCheckAndReset(AndroidDriver driver) {
        String resource = driver.getPageSource();
        if (resource != null) {
            if (resource.contains("隐私政策") && resource.contains("个人信息保护指引") && resource.contains("好的")) {
                logger.info("好的");
                click(561, 1887, driver);
            }else if (resource.contains("抖音短视频权限管理")){
                System.out.println(resource);
                logger.info("确定");
                driver.findElement(By.id("android:id/button1")).click();
                sleepTime(5000);
            } else if (resource.contains("青少年模式")) {
                System.out.println(resource);
                // 关闭打开青少年模式的通知
                logger.info("我知道了");
                click(605, 1630, driver);
            }else if (resource.contains("视频")) {
                System.out.println(resource);
                // 关闭打开青少年模式的通知
                logger.info("滑动");
                swipe(driver,459,1383,484,909);
                //坐标滑动
            }
        }
    }

    /**
     * 判定是否存在弹框通知需要关闭
     * @param pageSource
     * @return
     */
    private static boolean needToCheckAndClick(String pageSource) {
        if (pageSource != null) {
            return pageSource.contains("青少年模式")
                || pageSource.contains("隐私政策")
                || pageSource.contains("通知")
                || pageSource.contains("去打开")
                || pageSource.contains("个人信息保护指引")
                || pageSource.contains("好的")
                || pageSource.contains("抖音短视频权限管理")
                || pageSource.contains("视频");
        }

        return false;
    }

    /**
     * thread.sleep(millis)
     * @param millis
     */
    private static void sleepTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DouYinCrawlerThread thread = new DouYinCrawlerThread(false);
        thread.start();
    }
}

