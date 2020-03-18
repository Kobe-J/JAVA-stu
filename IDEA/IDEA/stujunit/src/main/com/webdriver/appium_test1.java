package com.webdriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yxl
 * java  selenium  appium 安卓
 * date 2020.1.4
 * */
public class appium_test1 {

                private static  AppiumDriver dri;


                //延时
                private static void time(long a){
                    try {
                        Thread.sleep(a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //启动APP
                @BeforeClass
                public static void qidong() throws MalformedURLException {
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setCapability("platformName", "Android");//手机系统
                    desiredCapabilities.setCapability("platformVersion", "9");//系统版本号
                    desiredCapabilities.setCapability("deviceName", "CLB0218523001219");//操控设备的deviceName
                    URL remoteUrl = new URL("http://localhost:4723/wd/hub");//appium 地址
                    dri = new AndroidDriver(remoteUrl, desiredCapabilities);
                }

                //case
                @Test
                public  void demo(){
                    MobileElement el1 = (MobileElement) dri.findElementByAccessibilityId("火箭猫单词");
                    el1.click();
                    time(3000);
                    MobileElement el2 = (MobileElement) dri.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup");
                    el2.click();
                    time(3000);
                    MobileElement el3 = (MobileElement) dri.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.ImageView");
                    el3.click();
                    time(3000);
                    MobileElement el4 = (MobileElement) dri.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]/android.widget.ImageView");
                    el4.click();
                    time(3000);
                    MobileElement el5 = (MobileElement) dri.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.ImageView");
                    el5.click();
                    time(3000);
                    MobileElement el6 = (MobileElement) dri.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup");
                    el6.click();
                    time(3000);
                    MobileElement el7 = (MobileElement) dri.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView");
                    el7.click();
                    time(3000);
                    MobileElement el8 = (MobileElement) dri.findElementByXPath("//android.widget.Button[@content-desc=\"Go back\"]/android.view.ViewGroup/android.widget.ImageView");
                    el8.click();
                }

                //退出APP返回主页面 并关闭线程
                @AfterClass
                public static void back(){
                    time(3000);
                    dri.quit();
                    dri.navigate().back();
                }
}
