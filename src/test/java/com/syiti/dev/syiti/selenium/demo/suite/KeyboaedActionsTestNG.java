package com.syiti.dev.syiti.selenium.demo.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author LinYoufeng
 * @version 1.0.0
 * @description TODO
 * @date 2019/9/25 9:41
 */
public class KeyboaedActionsTestNG {

    private static WebDriver driver;

    @Test(groups = {"priority"})
    public void test() throws InterruptedException {
        driver= BasicClass.driver;

        // 实例化Actions 对象
        Actions actions = new Actions(driver);
        driver.navigate().to("http://www.baidu.com");
        // 设置检查点，判断是否正确打开百度页面
        Assert.assertEquals(driver.getTitle(),"百度一下，你就知道");


        // WebDriver 中对超链接定位,并点击 “登录” 按钮
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(2000);
        // 选择账号密码登录
        driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();

        // 判断自动登录是否勾选，勾选了则取消
        if (driver.findElement(By.id("TANGRAM__PSP_10__memberPass")).isSelected()) {
            // 取消自动登录
            driver.findElement(By.id("TANGRAM__PSP_10__memberPass")).click();
        }
        // 输入账号密码
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("18089884962");
        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("951110feng");
        // 模拟键盘输入回车键登录
        actions.sendKeys(Keys.ENTER).perform();
        try {
            // 判断是否需要滑动滑块验证
            if (driver.findElement(By.xpath("//*[@id=\"vcode-slide-cover146\"]")).isDisplayed()) {
                // 获取需要滑动的滑块
                WebElement element = driver.findElement(By.xpath("//*[@id=\"vcode-slide-cover146\"]"));
                // 模拟鼠标滑动滑块
                actions.dragAndDropBy(element, 260, 0).perform();
            }
        } catch (Exception e) {
            System.out.println("滑块验证，出错了。请手工操作");
            Thread.sleep(3000);
        }
        // 判断是否登录成功
        boolean login = false;
        while (true) {
            if (ElementExist(driver, By.className("user-name"))) {
                login = true;
            }
            if (login) {
                Thread.sleep(2000);
                break;
            } else {
                Thread.sleep(5000);
            }
        }
        WebElement inputBox = driver.findElement(By.id("kw"));
        inputBox.sendKeys("皮皮丰最帅 - 使用WebElement的sendKeys 方法模拟");
        // 模拟键盘组合按键 ctrl+a,ctrl+x,ctrl+v
        // 使用WebElement的sendKeys 方法模拟
        inputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));

        inputBox.sendKeys(Keys.chord(Keys.CONTROL, "x"));

        inputBox.sendKeys(Keys.chord(Keys.CONTROL, "v"));

        inputBox.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        // 使用actions 的keyDown 和keyUp 方法模拟

        inputBox.clear();
        inputBox.sendKeys("皮皮丰最帅 - 使用actions 的keyDown 和keyUp 方法模拟");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();

        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        // 最大化
        driver.manage().window().maximize();
        Thread.sleep(5000);
        // 退出登录
        WebElement user = driver.findElement(By.id("user"));
        actions.moveToElement(user).perform();
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.name("tj_logout"));
        actions.moveToElement(logout).click().perform();
        Thread.sleep(1000);

    }




    public boolean ElementExist(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
