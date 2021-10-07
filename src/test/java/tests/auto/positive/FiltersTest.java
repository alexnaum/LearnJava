package tests.auto.positive;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.Console;

import static environment_variables.Variables.Urls.OLX_FIND_CAR_URL;

public class FiltersTest extends BaseTest {

    @Test
    public void defaultFiltersValues(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
        String category = driver.findElement(By.id("choosecat")).getText();
        String maker = driver.findElement(By.cssSelector("#param_subcat span[data-default-label]")).getText();
        Assert.assertEquals(category, "Легковые автомобили");
        Assert.assertEquals(maker, "Все");
    }

    @Test
    public void checkBrandInTheList(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//*[@id='param_subcat']//*[@class='icon down abs']"))).click();
        elementsActionHelper.isElementInList("Acura", findCarPage.getListOfBrands());
    }

    @Test
    public void checkPriceFields(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
        findCarPage.setPrice("100", "1000");
    }

    @Test
    public void filterByMileAge(){
        String minV = "10000";
        String maxV = "70000";
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
        findCarPage.setMinMileAge(minV).setMaxMileAge(maxV);
        var minValue = driver.findElement(By.cssSelector("li#param_motor_mileage a.button-from")).getText();
        var maxValue = driver.findElement(By.cssSelector("li#param_motor_mileage a.button-to")).getText();
        Assert.assertEquals(minValue,minV + " км");
        Assert.assertEquals(maxValue,maxV + " км");
    }

    @Test
    public void sortingByPrice(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
        findCarPage.selectItemFormSortingList(3);
        var sortedList = findCarPage.getListOfPrice().stream().sorted();

        System.out.println(sortedList);
    }
}
