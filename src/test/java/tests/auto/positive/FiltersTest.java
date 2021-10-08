package tests.auto.positive;

import common.FiltersParam;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static environmentVariables.Variables.Urls.OLX_FIND_CAR_URL;

public class FiltersTest extends BaseTest {

    @BeforeMethod
    public void start(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeGeoSuggestions();
        basePage.closeCookieWindow();
    }

    @Test
    public void defaultFiltersValues(){
        String category = findCarPage.categoryFilter.getText();
        String maker = findCarPage.makerFilter.getText();
        Assert.assertEquals(category, "Легковые автомобили");
        Assert.assertEquals(maker, "Все");
    }

    @Test
    public void checkBrandInTheList(){
        elementsActionHelper.isElementInList("Acura", findCarPage.getListOfBrands());
    }

    @Test
    public void filterByMileAge(){
        String minV = "10000";
        String maxV = "70000";
        findCarPage.setMinMileAge(minV)
                   .setMaxMileAge(maxV);

        Assert.assertTrue(findCarPage.getMinFilterParameter("param_motor_mileage").contains(minV));
        Assert.assertTrue(findCarPage.getMaxFilterParameter("param_motor_mileage").contains(maxV));
    }

    @Test
    public void sortingByPrice(){
        findCarPage.selectItemFormSortingList(3);
        var sortedList = findCarPage.getListOfPrice().stream().sorted();

        System.out.println(sortedList);
    }
}
