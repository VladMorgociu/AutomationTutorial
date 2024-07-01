package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(String text){
        driver.switchTo().frame(text);
    }

    public void switchToChildFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void defaultContentMethod(){
        driver.switchTo().defaultContent();
    }
}