package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextDisappearTest extends TestBase {
    @Test
    public void verify1(){
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        WebElement text = driver.findElement(By.id("myDIV"));

        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//button[.='Toggle Hide and Show']"));
        button.click();
        Assert.assertFalse(text.isDisplayed()); //expected the condition to return false

    }


    @Test
    public void verify2(){
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");
        driver.switchTo().frame("iframeResult");
        WebElement text = driver.findElement(By.xpath("//body/p"));
        Assert.assertTrue(text.isDisplayed());
        WebElement button = driver.findElement(By.xpath("//body//button"));
        button.click();
        Assert.assertFalse(elementsDisplayed(By.xpath("//body//p")));


    }

   /**
   takes locator and returns if matching
   this locator exists
   @param by
   @return
    */

    public boolean elementsDisplayed(By by){
        //try find it
        //if can't find it,return false
        try{
           return driver.findElement(by).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }

    }





}
