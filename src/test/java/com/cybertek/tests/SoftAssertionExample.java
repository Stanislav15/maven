package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {
    @Test
    public void test1(){
        System.out.println("sratring");
        Assert.assertTrue(false);

        System.out.println("done");
    }

    @Test
    public void test2(){
        SoftAssert softAssert= new SoftAssert();

        System.out.println("starting ");
        softAssert.assertTrue(false);
        System.out.println("done");
        softAssert.assertEquals("google","etsy");
        softAssert.assertAll();
    }

    @Test
    public void test3(){
        SoftAssert softAssert = new SoftAssert();

        System.out.println("starting");
        softAssert.assertTrue(false);

        Assert.assertTrue(false);

        System.out.println("done");
        softAssert.assertAll();
    }
}
