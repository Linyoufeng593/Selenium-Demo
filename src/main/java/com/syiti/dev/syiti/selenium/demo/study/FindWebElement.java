package com.syiti.dev.syiti.selenium.demo.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/24 9:17
 */
public class FindWebElement {

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

        // WebDriver 根据Id定位元素,并点击 “百度一下” 按钮
        driver.findElement(By.id("su")).click();

        // WebDriver 中对超链接定位,并点击 “登录” 按钮
        driver.findElement(By.linkText("登录")).click();
        // 增加休眠时间，让网页渲染完成在进行下一步操作。不然会display属性修改时，网页没有渲染完成会报找不到元素的错误。
        Thread.sleep(1000);

        // xPath 定位网页元素
        driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_4__closeBtn\"]")).click();

        // WebDriver 中根据name属性进行定位
        driver.findElement(By.name("tj_trnews")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".focuslistnews>.bold-item>a")).click();
        Thread.sleep(3000);
        // 退出浏览器
        driver.quit();


    }
}
