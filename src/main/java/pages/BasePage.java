package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static environmentVariables.Variables.TimeOutVariables.EXPLICIT_WAIT_TIME;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "choosecat")
    private WebElement categoryFilter;

    //public final By category = By.xpath("");

    @FindBy(css = "button.cookie-close")
    private WebElement closeCookieButton;

    @FindBy(css = "div#cookiesBar")
    public WebElement cookiesWindow;

    @FindBy(css = "a#geo-suggestions-close")
    public WebElement closeGeoSuggestionsButton;

    @FindBy(css = "div.gtm-survey__close")
    public  WebElement closeSurveyButton;

    @Step("Go to URL {url}")
    public void goToUrl(String url)
    {
        driver.get(url);
    }

    public BasePage closeCookieWindow(){
        if(driver.findElements(By.cssSelector("button.cookie-close")).stream().count()!=0) {
            waitElementIsVisible(closeCookieButton).click();
        }
        return this;
    }

    public BasePage closeGeoSuggestions(){
        if(driver.findElements(By.cssSelector("a#geo-suggestions-close")).stream().count()!=0) {
            waitElementIsVisible(closeGeoSuggestionsButton).click();
        }
        return this;
    }

    public BasePage closeGtmSurveyWindow(){
        if(driver.findElements(By.cssSelector("div.gtm-survey__close")).stream().count()!=0){
            waitElementIsVisible(closeSurveyButton).click();
        }
       return this;
    }

    public WebElement waitElementIsVisible(WebElement element)
    {
        new WebDriverWait(driver, EXPLICIT_WAIT_TIME)
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementIsInvisibilyty(WebElement element)
    {
        new WebDriverWait(driver, EXPLICIT_WAIT_TIME)
                .until(ExpectedConditions.invisibilityOf(element));
        return element;
    }
    //#listContainer > div.listOverlay
    public void selectCategory(String cat){

    }

}
