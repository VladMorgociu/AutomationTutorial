package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTab;

    @FindBy(id = "windowButton")
    private WebElement newWindow;

    public void interactWithNewTab(){
        pageMethods.scrollPage(0, 150);
        LoggerUtility.info("The user scrolled down the page.");
        elementMethods.clickElement(newTab);
        LoggerUtility.info("The user clicked on the newly opened tab.");

        System.out.println(driver.getCurrentUrl()); //url-ul paginii curente pe care ne aflam
        windowMethods.switchSpecificTab(1);
        LoggerUtility.info("The user switched on another tab.");
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        LoggerUtility.info("The user closed the current tab.");
        windowMethods.switchSpecificTab(0);
        LoggerUtility.info("The user switched to a specific tab.");
    }

    public void interactWithNewWindow(){
        pageMethods.scrollPage(0, 150);
        LoggerUtility.info("The user scrolls down the page.");
        newWindow.click();
        LoggerUtility.info("The user clicked the new window.");

        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        LoggerUtility.info("The user switched to another tab.");
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        LoggerUtility.info("The user closed the current tab.");
    }
}