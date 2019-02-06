package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    /*
    go to https://the-internet.herokuapp.com/upload
upload file
click upload
verify text uploaded
     */

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/upload");

        //navigate "choise file"
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //location file
        String path = "/Users/mrs/Downloads/test.txt";

        //upload file
        chooseFile.sendKeys(path);

        //click upload
         driver.findElement(By.xpath("//*[@id='file-submit']")).click();



        Assert.assertTrue(
                driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());



    }
}
