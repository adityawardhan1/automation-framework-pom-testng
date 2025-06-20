package com.aditya.tests;


import com.aditya.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
 

    @Test
    public void dashboardLoadTest() {
        // Just verify the title or URL after loading the page
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains("swag"), "Dashboard page did not load correctly.");
    }
}
