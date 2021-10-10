package com.xzh.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Mob网址的工具类，主要功能有获取App Key,添加社交组件，登录组件等
 */
public class MobTechHelper {
    WebDriver driver;


    public String getAppKey() {
        //初始化
        driver = initWebDriver();
        //登录
        login(driver);
        //进入工作台
        enterWorkStateDirect();
        //创建应用
        String appKey=  createApp();
        return appKey;
    }

    private String createApp() {
        String createAppPath = "/html/body/div[1]/div[2]/div/div/div[2]/div/div/div[1]/button";


        driver.findElement(By.xpath(createAppPath)).click();
        String appNamePath = "/html/body/div[10]/div[2]/div/div/div[2]/div/ul/li[2]/div[1]/div/input";
        driver.findElement(By.xpath(appNamePath)).sendKeys("test3");

        //driver.findElement(By.XPATH,uploadPath).click();
        String inputFilePath = "/html/body/div[10]/div[2]/div/div/div[2]/div/ul/li[1]/div[1]/div/div/input";
        driver.findElement(By.xpath(inputFilePath)).sendKeys("/home/xzh/Pictures/team.png");
        System.out.println("正在上传图片...");
        //等待图片上传完成
        System.out.println("完成上传图片...");

        String btnUploadOkPath = "/html/body/div[10]/div[2]/div/div/div[3]/div/a[2]";

        sleepUntil(5);
        driver.findElement(By.xpath(btnUploadOkPath)).click();
        String appKeyTextPath = "//*[@id='MobApp']/div[2]/div/div/div[2]/div/div/div[2]/div[2]/ul/li[1]/div/div[1]/div[2]/div[2]";
         sleepUntil(2);
        String appKey=driver.findElement(By.xpath(appKeyTextPath)).getText();
        return appKey.replace("App Key ","").trim();
    }

    private String getAppKeyInner() {
       return null;
    }

    /**
     * 进入工作台，这个方法会跳转到别的网址
     *
     * @deprecated
     */
    private void enterWorkState() {
        String workStatePath = "/html/body/div/div/div/header/div/div/div[2]/div[1]/div/a";
        String devPath = "/html/body/div/div/div/header/div/div/div[2]/div[1]/ul/li[1]/div[2]/div";

        WebElement workState = driver.findElement(By.linkText("工作台"));
        Actions actions = new Actions(driver);
        actions.moveToElement(workState).perform();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath(devPath)).click();
        System.out.println(driver.getCurrentUrl());
        System.out.println("进入工作台...");

    }

    /**
     * 通过网址直接进入工作台
     */
    private void enterWorkStateDirect() {
        String workStatePath = "/html/body/div/div/div/header/div/div/div[2]/div[1]/div/a";
        String devPath = "/html/body/div/div/div/header/div/div/div[2]/div[1]/ul/li[1]/div[2]/div";

        WebElement workState = driver.findElement(By.linkText("工作台"));
        Actions actions = new Actions(driver);
        actions.moveToElement(workState).perform();

        implicitlyWait(2);
     //   driver.findElement(By.xpath(devPath)).click();
        System.out.println(driver.getCurrentUrl());
        System.out.println("进入工作台...");
        driver.get("https://new.dashboard.mob.com/#/summary");
        System.out.println("进入工作台...");
        implicitlyWait(20);
    }


    private void login(WebDriver driver) {
        //登录
        System.out.println("打开登录网址...");
        driver.get("https://www.mob.com/developer/login");
        System.out.println("输入帐号密码...");
        String usernamePath = "/html/body/div[1]/div/div/section/div/div[2]/div[2]/section/div[4]/div[1]/form/div[1]/div/div[1]/input";
        String pwdPath = "/html/body/div[1]/div/div/section/div/div[2]/div[2]/section/div[4]/div[1]/form/div[2]/div/div[1]/input";
        String loginPath = "/html/body/div[1]/div/div/section/div/div[2]/div[2]/section/div[4]/div[1]/form/div[3]/div/button";
        driver.findElement(By.name("accounts")).sendKeys("13216169563");
        driver.findElement(By.xpath(pwdPath)).sendKeys("19930829xzh");
        driver.findElement(By.xpath(loginPath)).click();

        System.out.println("登录完成...");
        implicitlyWait(10);
    }

    private void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void sleepUntil(int seconds){
        try {
            sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private WebDriver initWebDriver() {
        //初始化
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    public static void main(String[] args) {
        MobTechHelper helper = new MobTechHelper();
        String appKey = helper.getAppKey();
        System.out.println(appKey);

    }
}
