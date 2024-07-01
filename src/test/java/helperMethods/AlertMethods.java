package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    public WebDriver driver;


    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForAlert () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlert();
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
    }

    public void dismissAlert() {
        waitForAlert();
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.dismiss();
    }

    public void fillAlert(String value) {
        Alert alertPromt = driver.switchTo().alert();
        System.out.println(alertPromt.getText());
        alertPromt.sendKeys(value);
        alertPromt.dismiss();
    }
}
