package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
open browser
go to amazon
open search term and submit
verify search box still contains the same search term
 */
public class AmazonSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));

        input.sendKeys("charger" + Keys.ENTER);

        String searchTerm = "charger";

        String actualTerm = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

        if (searchTerm.equals(actualTerm)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("ACTUAL :" + searchTerm);
            System.out.println("EXPECTED :" + actualTerm);
        }
    }
}
