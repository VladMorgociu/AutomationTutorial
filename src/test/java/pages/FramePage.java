package pages;

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
        frameMethods.defaultContentMethod();
    }

    public void interactWithSmallFrame(){
        frameMethods.switchToFrame("frame2");
        System.out.println(iFrame2Text.getText());
        frameMethods.defaultContentMethod();
    }

    public void  navigateToNestedFrames(){

        elementMethods.clickElement(nestedFramesSubmenu);
    }
}
