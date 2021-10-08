package tests.auto.negative;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static environmentVariables.Variables.Urls.OLX_FIND_CAR_URL;

public class FiltersTest extends BaseTest {

    @BeforeTest
    public void start(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
    }
    @DataProvider(name  = "data-provider")
    public Object[][] dataProviderMethod(){
      return new Object[][] {{"ABC"},{"!@#"}, {"1000.9"}, {"#A"}, {"  "}, {"10000"}};
    }

    @Test(dataProvider = "data-provider")
    public void filterByMileage(String v){
        findCarPage.setMinMileAge(v)
                   .setMaxMileAge(v);
        Assert.assertEquals(findCarPage.getMinFilterParameter("param_motor_mileage"), "");
        Assert.assertEquals(findCarPage.getMaxFilterParameter("param_motor_mileage"), "");
    }
}
