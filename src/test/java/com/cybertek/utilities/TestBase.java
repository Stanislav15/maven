package com.cybertek.utilities;

import com.cybertek.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;
    protected HomePage homePage;


    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        homePage = new HomePage();

    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
        softAssert.assertAll();
    }
}

