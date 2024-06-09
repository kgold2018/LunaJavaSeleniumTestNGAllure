
package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    private WebDriver driver;
   // private final String browser = "chrome";
//   private final String browser = "firefox";
    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Parameters("browser")
  //  String browser
    @BeforeMethod
    protected void setupDriver(String browser) {
        Reporter.log("--------------------------------------------------------------------------", true);
        this.driver = DriverUtils.createDriver(browser, this.driver);

        if(getDriver() == null) {
            Reporter.log("ERROR: Unknown parameter 'browser' - '" + browser + "'.", true);

            System.exit(1);
        }

        Reporter.log("INFO: " + browser.toUpperCase() + " driver created.", true);
//        if(this.browser.equals("chrome")) {
//            this.driver = DriverUtils.createChromeDriver(getDriver());
//            Reporter.log("INFO: Chrome browser created.", true);
//        } else {
//            Reporter.log("ERROR: Unknown parameter 'browser' - '" + this.browser + "'.", true);
//            System.exit(1);
//        }
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void tearDown(String browser) {
        if (this.driver != null) {
            getDriver().quit();
            Reporter.log("INFO: " + browser.toUpperCase() + " driver closed.", true);

            this.driver = null;
        } else {
            Reporter.log("INFO: Driver is null", true);
        }
    }

    public WebDriver getDriver() {

        return this.driver;
    }

}