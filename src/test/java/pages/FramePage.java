package pages;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {

    public WebDriver driver;
    public ElementMethods  elementMethods;
    public PageMethods  pageMethods;
    public FrameMethods frameMethods;

    public FramePage(WebDriver driver) {
        this.driver=driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "sampleHeading")
    public WebElement iFrame1Text;

    @FindBy(id = "sampleHeading")
    public WebElement iFrame2Text;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement nestedFramesSubmenu;



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
