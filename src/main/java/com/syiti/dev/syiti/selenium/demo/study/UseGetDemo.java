package com.syiti.dev.syiti.selenium.demo.study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/23 16:09
 */
public class UseGetDemo {

    public static void main(String[] args) {
        // 定义chrome driver 的获取地址，不同浏览器驱动不同
        // 谷歌浏览器
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\driver\\chromedriver.exe");
        // 火狐浏览器
//        System.setProperty("webdriver.gecko.driver","E:\\selenium\\driver\\geckodriver.exe");
        // 创建driver对象 不同浏览器创建不同的对象，以下为Chrome浏览器
//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        // 通过driver对象的get方法来打开相应的页面
        driver.get("http://www.baidu.com");
        // 最大化浏览器窗口
        driver.manage().window().maximize();
        // 使用getTitle 获取页面的Title 信息
        String title = driver.getTitle();

        System.out.println("Title = " + title);

        // 使用getCurrentUrl获取URL地址
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        // 退出浏览器
        driver.quit();

    }
}
