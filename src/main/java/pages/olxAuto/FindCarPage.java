package pages.olxAuto;

import common.FiltersParam;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

public class FindCarPage extends BasePage{
    //WebDriver driver;
    public FindCarPage(WebDriver driver) {
        //this.driver = driver;
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //private final By categoryFilter =  By.id("choosecat");
    @FindBy(id = "choosecat")
    public WebElement categoryFilter;

    @FindBy(css = "#param_subcat span[data-default-label]")
    public WebElement makerFilter;

    @FindBy(css = "#param_price input[class*='min-value-input']")
    private WebElement lowPrice;

    @FindBy(css = "#param_price input[class*='max-value-input']")
    private WebElement highPrice;

    @FindBy(css = "#param_motor_year input[class*='min-value-input']")
    private WebElement fromYear;

    @FindBy(css = "#param_motor_year input[class*='max-value-input']")
    private WebElement toYear;

    @FindBy(css = "#param_motor_mileage input[class*='min-value-input']")
    private WebElement minMileage;

    @FindBy(css = "#param_motor_mileage input[class*='max-value-input']")
    private WebElement maxMileage;

    @FindBy(css = "#targetorder-select-gallery")
    private WebElement sortingList;

    public FindCarPage selectItemFormSortingList(int v){
        sortingList.click();
        driver.findElement(By.cssSelector("#targetorder-select-gallery ul li:nth-of-type("+v+")")).click();
        return this;
    }
    public List<WebElement> getListOfBrands(){
        waitElementIsVisible(driver.findElement(By.xpath("//*[@id='param_subcat']//*[@class='icon down abs']"))).click();
        return driver.findElements(By.xpath("//li[@id=\"param_subcat\"]//ul/li/a[contains(@class,'search-choose') and not(contains(@class,'counter'))]")).stream().toList();
    }

    public void selectVehicle(int index){
        List<WebElement> list = driver.findElements(By.cssSelector("#offers_table h3 a")).stream().toList();
        list.get(index).click();
    }

    public int getOffersList(){
        List<WebElement> list = driver.findElements(By.cssSelector("#offers_table h3 a")).stream().toList();
        return list.size();
    }

    public List<WebElement> getListOfPrice(){
        return driver.findElements(By.cssSelector("td.offer .price strong")).stream().toList();
    }

    public FindCarPage setPrice(String lPrice, String hPrice){
        driver.findElement(By.cssSelector("li#param_price a.button-from")).click();
        lowPrice.clear();
        lowPrice.sendKeys(lPrice);
        driver.findElement(By.cssSelector("li#param_price a.button-to")).click();
        highPrice.clear();
        highPrice.sendKeys(hPrice);
        return this;
    }

    public FindCarPage selectBrand(){
      driver.findElement(By.xpath("//li[@id=\"param_subcat\"]//div[contains(@class, \"category-item\")]")).click();
      //driver.findElements(By)
        return this;
    }

    public FindCarPage setMinMileAge(String v){
        driver.findElement(By.cssSelector("li#param_motor_mileage a.button-from")).click();
        minMileage.clear();
        minMileage.sendKeys(v);
        return this;
    }

    public FindCarPage setMaxMileAge(String v){
        driver.findElement(By.cssSelector("li#param_motor_mileage a.button-to")).click();
        maxMileage.clear();
        maxMileage.sendKeys(v);
        return this;
    }

    public String getMinFilterParameter(String param){
        return waitElementIsVisible(driver.findElement(By.cssSelector("li#"+param+" a.button-from"))).getText();
    }
    public String getMaxFilterParameter(String param){
        return waitElementIsVisible(driver.findElement(By.cssSelector("li#"+param+" a.button-to"))).getText();
    }
}
