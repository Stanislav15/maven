package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {
    @AfterMethod
    public void close(){
        Driver.closeDriver();
    }

    @Test

    public void test() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");


        //click on enable
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']//button")).click();

        //class for used to explicit waits/just create object and wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        //we are waiting for certain element this xpath to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));



        //enter text
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("helo world");
    }

}
