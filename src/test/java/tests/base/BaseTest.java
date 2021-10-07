package tests.base;

import common.DriverFactory;
import helpers.ElementsActionHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.BasePage;
import pages.olxAuto.FindCarPage;

import static environment_variables.Variables.Urls.OLX_FIND_CAR_URL;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected FindCarPage findCarPage;
    protected  WebDriverWait wait;
    protected ElementsActionHelper elementsActionHelper;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        findCarPage = new FindCarPage(driver);
        elementsActionHelper = new ElementsActionHelper(driver);
        driver.manage().window().maximize();
        }

    //@AfterMethod
    public void tearDown(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        driver.quit();
    }
}
