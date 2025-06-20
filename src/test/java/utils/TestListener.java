package com.aditya.listeners;

import com.aditya.base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver;

        if (driver != null) {
            try {
                // Create timestamped file name
                String methodName = result.getName();
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = methodName + "_failed_" + timestamp + ".png";

                // Capture screenshot
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destDir = new File("screenshots");
                destDir.mkdirs(); // Ensure directory exists

                File destFile = new File(destDir, fileName);
                Files.copy(screenshot.toPath(), destFile.toPath());

                System.out.println("📸 Screenshot saved at: " + destFile.getAbsolutePath());

            } catch (IOException e) {
                System.err.println("❌ Failed to save screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Driver was null. Could not capture screenshot.");
        }
    }

    // You can also override other methods if needed (onTestStart, onTestSuccess, etc.)
}
