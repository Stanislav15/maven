package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import com.sun.tools.doclets.formats.html.PackageUseWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample extends TestBase {

    @Test
    public void printWhoTable(){
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }

    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
    }


    @Test
    public void printAllHeaders(){
        login();
        List<WebElement> headers =
                driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for(WebElement header: headers){
            System.out.println(header.getText());
        }
    }

    @Test
    public void printRow(){
        login();
        List<WebElement> allRows =
                driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        for (WebElement header: allRows) {

            System.out.println(header.getText());
        }

        //print the nth
        System.out.println("printing row " + 3);
        System.out.println(allRows.get(2).getText());


    }

    @Test
    public void printTableSize(){
        login();
        List<WebElement> allRows =
                driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("number of rows "+ allRows.size());

        List<WebElement> allHeaders = driver.
                findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("number of cols "+ allHeaders.size());


    }
    /*
    print row without using list
     */
    @Test
    public void printRow2() {
        login();
        WebElement row = driver.findElement
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));
        System.out.println(row.getText());

    }

    /*
    print all the cells of a row whose idx is given the xpath
     */
    @Test
    public void printAllCellsOneRow(){
        login();
        List<WebElement> cells=driver.findElements
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

        for(WebElement header:cells){
            System.out.println(header.getText());
        }

    }

    @Test
    public void printByCoordinates(){
        login();
        WebElement cell = driver.
                findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));
        System.out.println(getcell(6,11).getText());
    }

    public WebElement getcell(int row, int col){
        String xpath="//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public void printColum(){
        login();
        List<WebElement>allNames = driver.
                findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for (WebElement header:allNames){
            System.out.println(header.getText());
        }

    }

    @Test
    public void selectCheckBox(){
        login();
        WebElement check = driver.
                findElement(By.xpath("//td[.='Susan McLaren']/../td[1]/input"));
        System.out.println(check.isSelected());
        check.click();
        System.out.println(check.isSelected());

    }

    /*
    verify that name 'Mark Smith	' exists in the names colum
    verify that city 'anytown' exists int the cities colum
     */

    @Test
    public void test(){
        login();
        int nameIndex=  getColumIndex("Name");
        System.out.println(nameIndex);

        List<WebElement> allNames=
                driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));
        boolean found = false;
        for (int i = 0; i <allNames.size() ; i++) {
            if(allNames.get(i).getText().equals("Mark Smith")){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);



        int cityIndex= getColumIndex("City");
        List<WebElement> allCities=
                driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+cityIndex+"]"));
        for (int i = 0; i <allCities.size() ; i++) {
            if(allCities.get(i).getText().equals("Whitestone, British")){
                found=true;
                break;
            }
        }

        Assert.assertTrue(found);


    }


    /*
    get a colum name as a parametrs
    return the index of the colum name
     */
    public int getColumIndex(String colum){
        List<WebElement> allHeader=driver.
                findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for(int i = 0;i<allHeader.size();i++){
            if(allHeader.get(i).getText().equals(colum)){
                return i+1;
            }
        }
        return 0;
    }
}
