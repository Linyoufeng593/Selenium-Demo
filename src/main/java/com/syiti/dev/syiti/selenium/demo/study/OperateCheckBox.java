package com.syiti.dev.syiti.selenium.demo.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/24 10:33
 */
public class OperateCheckBox {

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

        // WebDriver 中对超链接定位,并点击 “登录” 按钮
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(2000);

        // 点击立即注册
        driver.findElement(By.xpath("//*[@id=\"passport-login-pop-dialog\"]/div/div/div/div[3]/a")).click();
        Thread.sleep(1000);

        // 切换Tab页
        switchWindow(driver);

        WebElement checkBox = driver.findElement(By.id("TANGRAM__PSP_4__isAgree"));
        // 判断条款复选框是否为显示
        boolean displayed = checkBox.isDisplayed();
        System.out.println("复选框是否显示出来：" + displayed);
        Thread.sleep(1000);
        // 判断条款复选框是否为勾选
        boolean selected = checkBox.isSelected();
        System.out.println("复选框是否被勾选： " + selected);
        Thread.sleep(1000);
        // 取消复选框勾选
        checkBox.click();
        Thread.sleep(1000);
        // 判断条款复选框是否为勾选
        selected = checkBox.isSelected();
        System.out.println("复选框是否被勾选： " + selected);
        Thread.sleep(1000);
        // 退出浏览器
        driver.quit();
    }

    /**
     *
     * 切换Tab页面
     * @author LinYoufeng
     * @date 11:07 2019/9/24
     * @param [driver]
     * @return void
     **/
    public static void switchWindow(WebDriver driver){
        Set<String> handles = driver.getWindowHandles();
        String current = driver.getWindowHandle();
        handles.remove(current);
        String newTab = handles.iterator().next();
        driver.switchTo().window(newTab);
    }

}
