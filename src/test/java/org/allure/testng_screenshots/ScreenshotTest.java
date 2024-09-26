package org.allure.testng_screenshots;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenshotTest {

    private ChromeDriver driver;

    @BeforeClass
    public void setupDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void openPage() {
        driver.get("https://en.wikipedia.org/wiki/Software_testing");

        // intentional failure
        Assert.assertFalse(driver.getTitle().contains("Software testing"));
    }

    @AfterMethod
    public void attachScreenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            Util.takeScreenshotAllure(driver, "failure screenshot");
        }
    }

    @AfterClass
    public void teardownDriver() {
        driver.quit();
    }


}
