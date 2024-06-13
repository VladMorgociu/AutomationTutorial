package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit url
        driver.get("https://demoqa.com/");

        //Maximizam dimensiunile browserului
        driver.manage().window().maximize();

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Definim un obiect de tip alert methods ca sa apelam metodele generale din clasa
        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);


        //Facem scroll paginii pentru vizibilitate

        //JavascriptExecutor js = (JavascriptExecutor) driver;
       //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);


        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //elementsMenu.click();
        elementMethods.clickElement(elementsMenu);


        WebElement alertMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        //alertMenu.click();
        elementMethods.clickElement(alertMenu);

        //interactionam cu o alerta
        WebElement alertOkButton = driver.findElement(By.id("alertButton"));
        //alertOkButton.click();
        elementMethods.clickElement(alertOkButton);

        alertMethods.acceptAlert();
      //  Alert alertOk = driver.switchTo().alert();
      // System.out.println(alertOk.getText());
      //  alertOk.accept();

        WebElement alertConfirmButton = driver.findElement(By.id("confirmButton"));
        //alertConfirmButton.click();
        elementMethods.clickElement(alertConfirmButton);

        alertMethods.dismissAlert();

       // Alert alertConfirm = driver.switchTo().alert();
       // System.out.println(alertConfirm.getText());
       // alertConfirm.dismiss();

        WebElement alertPromtButton = driver.findElement(By.id("promtButton"));
        //alertPromtButton.click();
        elementMethods.clickElement(alertPromtButton);

        // Alert alertPromt = driver.switchTo().alert();
        //System.out.println(alertPromt.getText());
        //alertPromt.dismiss();

        alertMethods.fillAlert("Vlad");


        //Interactionam cu o alerta pentru care trebuie sa asteptam
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        //timerAlertButton.click();
        elementMethods.clickElement(timerAlertButton);

        alertMethods.acceptAlert();

        //Definim un wait explicit
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.alertIsPresent());

        //Alert waitConfirm = driver.switchTo().alert();
        //System.out.println(waitConfirm.getText());
        //waitConfirm.accept();
    }
}
