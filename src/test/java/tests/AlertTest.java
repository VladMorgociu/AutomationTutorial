package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertsWindowsPage;
import pages.HomePage;
import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToAlertsForm();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.interactAlertOk();
        alertPage.interactConfirmButton();
        alertPage.interactPromtButton("Test cu succes");
        alertPage.interactTimerAlertButton();
    }
}
