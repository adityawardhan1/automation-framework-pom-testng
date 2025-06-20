

package com.aditya.tests;


import com.aditya.base.BaseTest;
import com.aditya.pages.LoginPage;
import com.aditya.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
  

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.login(username, password);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "Login failed or did not redirect correctly.");
    }
}
