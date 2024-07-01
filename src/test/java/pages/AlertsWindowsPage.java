package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsWindows {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);

    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindows;

    public void navigateToWindowPage(){
        elementMethods.clickElement(browserWindows);
    }
}
