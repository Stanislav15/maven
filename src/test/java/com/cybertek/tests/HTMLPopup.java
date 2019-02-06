package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HTMLPopup {
    WebDriver driver;

    //https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    public void doNotDestroyTheWorldtest(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//span[.='No']")).click();

    }

    @Test
    public void oopsTest(){
        driver.get("https://sweetalert.js.org/");
        // trigger the pop up
        driver.findElement(By.xpath("(//button[@class='preview'])[2]")).click();
                // close the pop up
                driver.findElement(By.xpath("//button[.='OK']")).click();
    }

}
