package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleDemo extends TestBase {

    @Test
    public void titleTest(){
        driver.get("https:/google.com");
        driver.findElement(By.name("q")).sendKeys("selenium cookbok"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("selenium cookbook"));
    }
}
