package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MixedUpDependencies {
    @Test
    public void openBrowser(){
        System.out.println("opening  browser");
        //Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "openBrowser",priority = 0)
    public void login() {
        System.out.println("login");
        //Assert.assertTrue(false);

    }

    @AfterMethod
    public void cleanUp(){
        System.out.println("close browser");
    }
}
