package com.syiti.dev.syiti.selenium.demo.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/25 9:23
 */

public class OpenWebsiteTestNG {

    /**
     * @BeforeClass 执行 @Test 之前执行的步骤
     * @Test 具体执行的测试步骤
     * @AfterClass 执行完 @Test 之后执行的步骤
     **/

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        // 定义chrome driver 的获取地址，不同浏览器驱动不同
        // 谷歌浏览器
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\driver\\chromedriver.exe");
        // 创建driver对象 不同浏览器创建不同的对象，以下为Chrome浏览器
        driver = new ChromeDriver();
        // 设置统一等待时长，最多等待10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        // 最大化浏览器窗口
        driver.manage().window().maximize();
        // 通过driver对象的get方法来打开相应的页面
        driver.get("http://www.baidu.com");

        WebElement inputBox = driver.findElement(By.id("kw"));

        // 获取百度文本输入框并输入的内容"selenium"
        inputBox.sendKeys("selenium");
        // 点击百度一下
        driver.findElement(By.id("su")).click();
        // 重新获取输入框
        String value = inputBox.getAttribute("value");
        System.out.println("文本框内的值为: " + value);
        // 清空
        inputBox.clear();

    }

    @AfterClass
    public void tearDown(){
        // 退出浏览器
        driver.quit();
    }


}
