package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class ElementsActionHelper extends BasePage {

    public ElementsActionHelper(WebDriver driver) {
        super(driver);
    }

    //List actions

    public void isElementInList(String value, List<WebElement> list){
         Assert.assertTrue(list.stream().filter(ex -> ex.getText().contains(value)).findFirst()
                .orElseThrow(NullPointerException::new).isDisplayed());
    }

    public String getValueOfCharacteristic(String value, List<WebElement> list){
        return list.stream().filter(ex -> ex.getText().contains(value)).findFirst().toString();
    }

    public WebElement findFirstItemInList(List<WebElement> list){
       return list.stream().findFirst().get();
    }
}
