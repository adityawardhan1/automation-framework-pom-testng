package com.aditya.base;

import com.aditya.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver; // 🔓 Made public so TestListener can access it

    @BeforeMethod
    public void setUp() {
        // Step 1: Load the config
        ConfigReader.loadConfig();

        // Step 2: Read values
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("baseUrl");

        // Step 3: Initialize driver safely
        if (browser != null && browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        } else {
            System.out.println("❌ Invalid or missing 'browser' property in config. Skipping driver initialization.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
