package com.syiti.dev.syiti.selenium.demo.study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/24 9:02
 */
public class UseNavigateDemo {

    public static void main(String[] args) throws InterruptedException {
        // 定义chrome driver 的获取地址，不同浏览器驱动不同
        // 谷歌浏览器
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\driver\\chromedriver.exe");

        // 创建driver对象 不同浏览器创建不同的对象，以下为Chrome浏览器
        WebDriver driver = new ChromeDriver();

        // 通过driver对象的navigate().to(url)方法来打开相应的页面,效果等同于driver.get(url);
        driver.navigate().to("http://www.baidu.com");

        // 最大化浏览器窗口
        driver.manage().window().maximize();
        // 刷新当前页面
        driver.navigate().refresh();
        // 使用getTitle 获取页面的Title 信息
        String title = driver.getTitle();

        System.out.println("Title = " + title);
        // 转跳另一个页面
        driver.get("https://www.csdn.net/");
        // 使用getTitle 获取页面的Title 信息
        title = driver.getTitle();
        System.out.println("Title = " + title);

        //返回上一个页面
        driver.navigate().back();
        title = driver.getTitle();
        System.out.println("Title = " + title);

        // 返回下一个页面
        driver.navigate().forward();
        title = driver.getTitle();
        System.out.println("Title = " + title);

        Thread.sleep(3000);

        // 退出浏览器
        driver.quit();

    }
}
