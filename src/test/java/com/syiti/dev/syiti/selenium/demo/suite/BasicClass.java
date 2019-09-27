package com.syiti.dev.syiti.selenium.demo.suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/25 10:41
 */
public class BasicClass {

    public static WebDriver driver;

    /**
     *
     *   @BeforeSuite(alwaysRun = true) 在分组启动时必须加上 alwaysRun = true ，否则无法执行
     * @author LinYoufeng
     * @date 8:50 2019/9/26
     * @param []
     * @return void
     **/
    @BeforeSuite(alwaysRun = true)
    public void before(){
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\driver\\chromedriver.exe");
        // 创建driver对象 不同浏览器创建不同的对象，以下为Chrome浏览器
        driver = new ChromeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void after(){
        // 退出浏览器
        driver.quit();
    }

}
