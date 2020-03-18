package com.webdriver;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

                private static WebDriver driver;
                static void sleep(long a){
                    try {
                        Thread.sleep(a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                @BeforeClass
                public static void beforeClass() throws InterruptedException {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\EDZ\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
                    driver= new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.get("http://www.baidu.com");
                    System.out.println("The testing page title is: " + driver.getTitle());
                    sleep(3000);
                }

                @Test
                public void test(){
                    driver.findElement(By.id("kw")).sendKeys("java");
                    sleep(3000);
                    driver.findElement(By.id("su")).click();
                }

                @After
                public void after(){
                    sleep(3000);
                        driver.quit();
                }
}