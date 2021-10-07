package tests.auto.negative;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static environment_variables.Variables.Urls.OLX_FIND_CAR_URL;

public class FiltersTest extends BaseTest {

    @Test
    public void filterByMileAge(){
        String minV = "ABC";
        String maxV = "ABC";
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
        findCarPage.setMinMileAge(minV);
        var minValue = driver.findElement(By.cssSelector("li#param_motor_mileage a.button-from")).getText();
        findCarPage.setMaxMileAge(maxV);
        var maxValue = driver.findElement(By.cssSelector("li#param_motor_mileage a.button-to")).getText();
        Assert.assertEquals(minValue,"");
        Assert.assertEquals(maxValue,"");
    }
}
