package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    public WebElement alertButtonOk;

    @FindBy(id = "confirmButton")
    public WebElement alertConfirmButton;

    @FindBy(id = "promtButton")
    public WebElement alertPromtButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

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