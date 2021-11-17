package tests.auto.positive;

import common.FiltersParam;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static environmentVariables.Variables.Urls.OLX_FIND_CAR_URL;

public class FiltersTest extends BaseTest {

    @BeforeMethod
    public void start(){
        basePage.goToUrl(OLX_FIND_CAR_URL);
        basePage.closeGtmSurveyWindow();
        basePage.closeCookieWindow();
        basePage.closeGeoSuggestions();
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
    public void sortingByPriceGeneralList() throws InterruptedException {
        findCarPage.selectItemFormSortingList(3);
        var sortedListSite = findCarPage.getGeneralListOfPrice()
                .stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> sortedListReal =  sortedListSite.stream().sorted(Comparator.reverseOrder()).toList();
        Assert.assertTrue(sortedListSite.stream().allMatch(new HashSet<>(sortedListReal)::contains));
    }

    @AfterMethod
    public void end(){
        //TODO add name of the test to logger
        logger.info("========END OF THE TEST===========");
    }
}
