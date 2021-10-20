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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.TestNGContentHandler;
import pages.BasePage;
import pages.olxAuto.FindCarPage;
import pages.olxAuto.VehicleInfoPage;

import java.io.File;
import java.io.IOException;
@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected FindCarPage findCarPage;
    protected VehicleInfoPage vehicleInfoPage;
    protected  WebDriverWait wait;
    protected ElementsActionHelper elementsActionHelper;
    protected Logger Logger = LogManager.getLogger();
    protected ITestResult testResult;


    @BeforeTest
    public void setUp(){
        driver = DriverFactory.createDriver();
        basePage = new BasePage(driver);
        findCarPage = new FindCarPage(driver);
        vehicleInfoPage = new VehicleInfoPage(driver);
        elementsActionHelper = new ElementsActionHelper(driver);
        }

    @AfterMethod
    public void clearCookiesAndLocalStorage(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
