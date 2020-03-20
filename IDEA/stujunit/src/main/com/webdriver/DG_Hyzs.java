package com.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DG_Hyzs {

    private static WebDriver dri;
    private static log_jietu_junit log;
    private String qu="默认区域1";
    //延时

    static void Thread(long a){
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
            @BeforeClass
            public static void test() throws InterruptedException {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\EDZ\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
                dri= new ChromeDriver();
                Thread(3000);
                dri.manage().window().maximize();
                Thread(3000);
                dri.get("http://www.baidu.com");
                Thread(3000);
                //获取当前窗口句柄
               // String search=dri.getWindowHandle();
               // Thread(3000);
               // dri.findElement(By.linkText("[个人网页版]")).click();
               // Thread(3000);
               // dri.switchTo().window(search);
                Thread(1000);
                dri.findElement(By.id("j_password")).sendKeys("do1admin");
                Thread(1000);
                dri.findElement(By.id("btn_login")).submit();
            }

            @Test
            public void test1() throws InterruptedException {
                Thread(2000);
                dri.findElement(By.xpath("//*[@id=\'content\']/span/a")).click();
                Thread(2000);
                dri.findElement(By.cssSelector("#leftMenu_application > li:nth-child(11)")).click();
                WebElement frame = dri.findElement(By.cssSelector("#personFrame"));
                dri.switchTo().frame(frame);
                Thread(2000);
                dri.findElement(By.cssSelector("#setmenu_aid")).click();
                Thread(2000);
                dri.findElement(By.id("meet_isLocation")).click();
                Thread(2000);
                //页面滑动 JS
                ((JavascriptExecutor) dri).executeScript("window.scrollBy(0,800)");//页面上下滑动
                Thread(2000);
                WebElement ws = dri.findElement(By.className("setting_r"));
                ws.click();
                Thread(3000);
                WebElement xt = dri.findElement(By.className("region-name"));
                String moren = xt.getText();
                Thread(2000);
                Actions ac = new Actions(dri);
                ac.moveToElement(xt).perform();
                Thread(2000);
                dri.findElement(By.xpath("//*[@id=\'3a0b8b7f-807d-48fb-80f4-c0de4934a7c8\']/div")).click();
                Thread(2000);
                dri.switchTo().defaultContent();
                WebElement sr = dri.findElement(By.xpath("//*[@id=\"add_edit\"]/form/div[1]/div/input"));
                Thread(1000);
                sr.click();
                Thread(1000);
                sr.clear();
                Thread(1000);
                sr.sendKeys(qu);
                Thread(2000);
                dri.findElement(By.id("saveRegion")).click();
                Thread(2000);
                if (moren == "") {
                    log= new log_jietu_junit("默认区域1",moren,"test1",dri);
                    System.out.println("并未获取到元素,用例执行失败,已截图保存");
                } else {
                    log= new log_jietu_junit("默认区域",moren,"test1",dri);
                    Assert.assertEquals(moren,"默认区域1");
                    System.out.println("对比数据为"+moren);
                }
            } @After
            public  void close(){
                Thread(5000);
                dri.quit();
                System.out.println("会议助手测试用例执行完毕");
    }
}
