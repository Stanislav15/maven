package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

/*
go to https://the-internet.herokuapp.com/forgot_password
verify enter email and submit
verify email sent message on the next page
"your e-mail's been sent!"
 */
public class SubmitEmail {
    public static void main(String[] args) {

        // setting driver path for chrome using the webdriver manager
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement input = driver.findElement(By.id("email"));

        input.sendKeys("stas.kis@mail.com"+ Keys.ENTER);

//        input.sendKeys("stas.kis@mail.com");  second way
//        input.submit();

        String expected = "your e-mail's been sent!";

        String actual = driver.findElement(By.id("content")).getText();

        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("EXPECTED =" + expected);
            System.out.println("ACTUAL =" + actual);
        }




    }
}
