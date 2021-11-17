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

    @BeforeMethod
    public void start(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeCookieWindow();
        basePage.closeGeoSuggestions();
    }
    @DataProvider(name  = "data-provider")
    public Object[][] dataProviderMethod(){
      return new Object[][] {{"ABC"},{"!@#"}, {"1000.9"}, {"#A"}, {"  "}};
    }

    @Test(dataProvider = "data-provider")
    public void filterByMileage(String v){
        findCarPage.setMinMileAge(v);
        Assert.assertEquals(findCarPage.getMinFilterParameter("param_motor_mileage"), "");
        findCarPage.setMaxMileAge(v);
        Assert.assertEquals(findCarPage.getMaxFilterParameter("param_motor_mileage"), "");
    }
}
