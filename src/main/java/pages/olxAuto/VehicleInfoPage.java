package pages.olxAuto;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Getter
public class VehicleInfoPage extends BasePage {
    public VehicleInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Пробег')]")
    private WebElement mileAge;

    public VehicleInfoPage getMileAge(){

        return this;
    }


}
