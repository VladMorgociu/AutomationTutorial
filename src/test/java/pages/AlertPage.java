package pages;

import loggerUtility.LoggerUtility;
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
        LoggerUtility.info("The user clicks the alert's OK button.");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user accepts the alert.");
    }

    public void interactConfirmButton(){
        elementMethods.clickElement(alertConfirmButton);
        LoggerUtility.info("The user clicks the alert's confirm button.");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user accepts the alert.");
    }

    public void interactPromtButton(String text){
        elementMethods.clickElement(alertPromtButton);
        LoggerUtility.info("The user clicks the alert's promt button.");
        alertMethods.fillAlert(text);
        LoggerUtility.info("The user fills the alert.");
    }

    public void interactTimerAlertButton(){
        elementMethods.clickElement(timerAlertButton);
        LoggerUtility.info("The user clicks the timed alert button.");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user accepts the alert.");
    }
}