package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.pages.ListinPage;
import com.cybertek.pages.PrestashopHomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {



    @Test
    public void wrongEmailTest(){

driver.get(ConfigurationReader.getProperty("url"));
        homePage.username.sendKeys("admin");
        homePage.password.sendKeys("test");
        homePage.loginbutton.click();

        String error = homePage.errorMessage.getText();
        Assert.assertEquals(error,"Invalid Login or Password.");
    }



    @Test
    public void wrongPasswordTest(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homePage.username.sendKeys("Tester");
        homePage.password.sendKeys("stas");
        homePage.loginbutton.click();

        String error = homePage.errorMessage.getText();
        Assert.assertEquals(error,"Invalid Login or Password.");
    }

@Test
    public void blankUserName(){
        homePage.open();

        homePage.login("","test");

        String error = homePage.errorMessage.getText();

        Assert.assertEquals(error,"Invalid Login or Password.");



}


@Test
    public void test(){
    ListinPage nilesLane = new ListinPage();

    ListinPage palmetLane = new ListinPage();

    PrestashopHomePage prestashopHomePage = new PrestashopHomePage();

    WebElement tshirt = prestashopHomePage.product("trgf");
    WebElement dress = prestashopHomePage.product("dress");
}




}
