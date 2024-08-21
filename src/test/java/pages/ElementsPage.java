package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTableSubmenu;

    public void navigateToTableSubmenu(){
        elementMethods.clickElement(webTableSubmenu);
        LoggerUtility.info("The user clicked the 'Web Tables' sub menu button.");
    }
}
