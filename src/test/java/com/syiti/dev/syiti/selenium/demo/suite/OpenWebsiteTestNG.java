package com.syiti.dev.syiti.selenium.demo.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    private static WebDriver driver;

    /**
     *
     *  @Test(groups = {"smoking"}) 设置分组，一个测试用例可以有多个分组，分组间使用逗号隔开
     * @author LinYoufeng
     * @date 8:53 2019/9/26
     * @param []
     * @return void
     **/
    @Test(groups = {"smoking"})
    public void test(){

        driver= BasicClass.driver;

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


}
