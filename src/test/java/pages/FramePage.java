package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement iFrame1Text;

    @FindBy(id = "sampleHeading")
    private WebElement iFrame2Text;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFramesSubmenu;

    public void interactWithBigFrame(){
        frameMethods.switchToFrame("frame1");
        System.out.println(iFrame1Text.getText());
        LoggerUtility.info("The user switched to the big iFrame.");
        frameMethods.defaultContentMethod();
        LoggerUtility.info("The user interacted with the big iFrame.");
    }

    public void interactWithSmallFrame(){
        frameMethods.switchToFrame("frame2");
        System.out.println(iFrame2Text.getText());
        LoggerUtility.info("The user switched to the small iFrame.");
        frameMethods.defaultContentMethod();
        LoggerUtility.info("The user interacted with the small iFrame.");
    }

    public void  navigateToNestedFrames(){

        elementMethods.clickElement(nestedFramesSubmenu);
        LoggerUtility.info("The user clicked the 'Nested Frames' sub menu.");
    }
}
