package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.olxAuto.FindCarPage;

import static environment_variables.Variables.TimeOutVariables.EXPLICIT_WAIT_TIME;

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

    public void goToUrl(String url)
    {
        driver.get(url);
    }
    //Question
    public BasePage closeCookieWindow(){
        waitElementIsVisible(closeCookieButton).click();
        //wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("div#cookiesBar"))));
        //new WebDriverWait(driver, EXPLICIT_WAIT_TIME).until(ExpectedConditions.stalenessOf(cookiesWindow));
        return this;
    }

    public BasePage closeGeoSuggestions(){
        waitElementIsVisible(closeGeoSuggestionsButton).click();
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
        new WebDriverWait(driver, EXPLICIT_WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void selectCategory(String cat){

    }

}
