package com.syiti.dev.syiti.selenium.demo.study;


import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/24 11:28
 */
public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
        // 定义chrome driver 的获取地址，不同浏览器驱动不同
        // 谷歌浏览器
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\driver\\chromedriver.exe");

        // 创建driver对象 不同浏览器创建不同的对象，以下为Chrome浏览器
        WebDriver driver = new ChromeDriver();

        // 通过driver对象的get方法来打开相应的页面
        driver.get("http://www.atool9.com/canvas.php");

        Thread.sleep(2000);

        // 实例化Actions 对象
        Actions actions = new Actions(driver);

        // 获取画板
        WebElement canvas = driver.findElement(By.id("canvas"));
        actions.doubleClick(canvas).perform();
        Thread.sleep(4000);


        // 获取指定元素
        WebElement element = driver.findElement(By.xpath("//*[@id=\"menu_list\"]/li[4]/a"));
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"menu_list\"]/li[4]/ul/li[16]/a"));
        // 将鼠标移动到指定元素上
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        // 将鼠标移动到指定元素上并点击
        actions.moveToElement(element1).click().perform();
        Thread.sleep(1000);


        // 退出浏览器
        driver.quit();
    }
}
