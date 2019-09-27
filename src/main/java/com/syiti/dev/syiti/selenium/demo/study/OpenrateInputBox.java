package com.syiti.dev.syiti.selenium.demo.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/24 10:06
 */
public class OpenrateInputBox {
    public static void main(String[] args) throws InterruptedException {
        // 定义chrome driver 的获取地址，不同浏览器驱动不同
        // 谷歌浏览器
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\driver\\chromedriver.exe");

        // 创建driver对象 不同浏览器创建不同的对象，以下为Chrome浏览器
        WebDriver driver = new ChromeDriver();

        // 最大化浏览器窗口
        driver.manage().window().maximize();
        // 通过driver对象的get方法来打开相应的页面
        driver.get("http://www.baidu.com");

        WebElement inputBox = driver.findElement(By.id("kw"));

        // 获取百度文本输入框并输入的内容
        inputBox.sendKeys("selenium");
        Thread.sleep(2000);
        // 点击百度一下
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        // 重新获取输入框
        String value = inputBox.getAttribute("value");
        System.out.println("文本框内的值为: " + value);
        Thread.sleep(2000);
        // 清空
        inputBox.clear();
        Thread.sleep(2000);
        // 退出浏览器
        driver.quit();
    }
}
