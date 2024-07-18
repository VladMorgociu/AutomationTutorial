package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertButtonOk;

    @FindBy(id = "confirmButton")
    private WebElement alertConfirmButton;

    @FindBy(id = "promtButton")
    private WebElement alertPromtButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;


    public void interactAlertOk() {
        elementMethods.clickElement(alertButtonOk);
        alertMethods.acceptAlert();
    }

    public void interactConfirmButton(){
        elementMethods.clickElement(alertConfirmButton);
        alertMethods.acceptAlert();
    }

    public void interactPromtButton(String text){
        elementMethods.clickElement(alertPromtButton);
        alertMethods.fillAlert(text);
    }

    public void interactTimerAlertButton(){
        elementMethods.clickElement(timerAlertButton);
        alertMethods.acceptAlert();
    }
}