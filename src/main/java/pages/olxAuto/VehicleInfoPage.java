package pages.olxAuto;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class VehicleInfoPage extends BasePage {
    public VehicleInfoPage(WebDriver driver) {
        super(driver);
    }

    @Getter
    @FindBy(xpath = "//*[contains(text(),'Пробег')]")
    private WebElement mileAge;


}
