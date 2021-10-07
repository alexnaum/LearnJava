package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER_NAME;
import static environment_variables.Variables.TimeOutVariables.IMPLICIT_WAIT_TIME;

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_NAME) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FireFox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Incorrect browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        return driver;
    }
}
