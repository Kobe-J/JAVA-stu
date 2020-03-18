
package com.webdriver;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 想要是使用有参构造器  的时候那么就需要由无参构造器的存在
 * 类里不写构造器的时候   那么类里面默认给一个无参构造器
 *
 */

public class log_jietu_junit {

    //创建一个构造器
    private  static  int i=0;
    private  static  int j=0;
    private static Logger logger = Logger.getLogger(log_jietu_junit.class);

    public   log_jietu_junit(){

    }
    /**
     * 有参构造器四个参数
     * 第一个：预期结果  String
     * 第二个：实际结果  String
     * 第三个：调用的方法名  String
     * 第四个：WebDriver;
     * @author yxl
     *
     */

    public  log_jietu_junit(String yu,String shi,String name,WebDriver  driver){

        if(yu.equals(shi)){
            i++;
            logger.error(name+"执行通过pass");
        }else{
            j++;
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile,new File("C:\\Users\\姚希龙\\Desktop\\"+name+getDateTime()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.error(name+"执行不通过false");
        }
        logger.error("执行通过的用例条数为："+i);
        logger.error("执行失败的用例条数为："+j);
    }

    public static String getDateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return df.format(new Date());
    }
}


