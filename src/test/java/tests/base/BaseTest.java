package tests.base;

import common.DriverFactory;
import helpers.ElementsActionHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.BasePage;
import pages.olxAuto.FindCarPage;
import pages.olxAuto.VehicleInfoPage;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected FindCarPage findCarPage;
    protected VehicleInfoPage vehicleInfoPage;
    protected  WebDriverWait wait;
    protected ElementsActionHelper elementsActionHelper;
    @BeforeTest
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        driver = DriverFactory.createDriver();
        basePage = new BasePage(driver);
        findCarPage = new FindCarPage(driver);
        vehicleInfoPage = new VehicleInfoPage(driver);

        elementsActionHelper = new ElementsActionHelper(driver);
        //driver.manage().window().maximize();
        }

    @AfterTest
    public void tearDown(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        driver.quit();
    }
}
