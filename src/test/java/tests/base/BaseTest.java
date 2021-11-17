package tests.base;

import common.DriverFactory;
import helpers.ElementsActionHelper;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.xml.TestNGContentHandler;
import pages.BasePage;
import pages.olxAuto.FindCarPage;
import pages.olxAuto.VehicleInfoPage;

import java.io.File;
import java.io.IOException;

import static common.Config.BROWSER_NAME;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected FindCarPage findCarPage;
    protected VehicleInfoPage vehicleInfoPage;
    protected  WebDriverWait wait;
    protected ElementsActionHelper elementsActionHelper;
    //protected Logger Logger = LogManager.getLogger();
    protected ITestResult testResult;
    protected ITestResult result = Reporter.getCurrentTestResult();
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    @Parameters(value={"browser","version","platform"})
    public void setUp(@Optional String browser, @Optional String version, @Optional String platform){
        driver = DriverFactory.createDriver();
        basePage = new BasePage(driver);
        findCarPage = new FindCarPage(driver);
        vehicleInfoPage = new VehicleInfoPage(driver);
        elementsActionHelper = new ElementsActionHelper(driver);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version",version);
        capabilities.setCapability("platform",platform);
        logger.info("========START TEST ============");
        logger.info("Browser: " + browser + "; Version: " + version+ "; Platform:" + platform);

    }

    @AfterMethod
    public void clearCookiesAndLocalStorage(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        logger.info("============CLEAR COOKIES================");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
