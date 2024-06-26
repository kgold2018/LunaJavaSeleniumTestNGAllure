
package com.lumatest.base;

import com.lumatest.data.TestData;
import com.lumatest.utils.DriverUtils;
import com.lumatest.utils.ReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class BaseTest {
    private WebDriver driver;
    private final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    protected void setupDriver(@Optional("chrome") String browser, ITestContext context, ITestResult result) {
        Reporter.log("--------------------------------------------------------------------------", true);
        this.driver = DriverUtils.createDriver(browser, this.driver);
        this.threadLocalDriver.set(this.driver);

      Reporter.log("Test Thread ID: " + Thread.currentThread().getId(), true);
      Reporter.log("TEST SUIT: " + context.getCurrentXmlTest().getSuite().getName(), true);
      Reporter.log("RUN " + result.getMethod().getMethodName(), true);

      if (getDriver() == null) {
        Reporter.log("ERROR: Unknown parameter 'browser' - '" + browser + "'.", true);

        System.exit(1);
      }

      Reporter.log("INFO: " + browser.toUpperCase() + " driver created.", true);
      Allure.step("Open base URL");
      getDriver().get(TestData.BASE_URL);
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void tearDown(@Optional("chrome") String browser, ITestResult result) {
      Reporter.log(result.getMethod().getMethodName() + ": " + ReportUtils.getTestStatus(result),
        true);

      if (getDriver() != null) {
        getDriver().quit();
        Reporter.log("INFO: " + browser.toUpperCase() + " driver closed.", true);

        Reporter.log("After Test Thread ID: " + Thread.currentThread().getId(), true);
        threadLocalDriver.remove();

        this.driver = null;

      } else {
        Reporter.log("INFO: Driver is null.", true);
      }
    }


    protected WebDriver getDriver() {
      return threadLocalDriver.get();
    }
}