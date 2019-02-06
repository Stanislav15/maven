package com.cybertek.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeDemo {

    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tinymce");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // locate the iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        //switch to iframe
        driver.switchTo().frame(iframe);


        driver.findElement(By.tagName("body")).clear();
        driver.findElement(By.tagName("body")).sendKeys("ddeee dddedd  dd");
        //gets you back to previous frame
        driver.switchTo().parentFrame();
        // gets you to the top level. first level
        //driver.switchTo().defaultContent();


        driver.findElement(By.linkText("Elemental Selenium")).click();




    }
}