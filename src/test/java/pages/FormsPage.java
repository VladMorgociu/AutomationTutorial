package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage {


    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceForm;

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPracticeForm(){
        elementMethods.clickElement(practiceForm);
        LoggerUtility.info("The user clicks on the practice form button.");
    }
}