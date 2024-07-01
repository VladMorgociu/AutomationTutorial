package tests;

import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;

import java.time.Duration;

public class FrameTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        PageMethods pageMethods = new PageMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();
        pageMethods.scrollPage(0, 350);

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToFramePage();

        FramePage framePage = new FramePage(driver);
        framePage.interactWithBigFrame();
        framePage.interactWithSmallFrame();
        framePage.navigateToNestedFrames();

        NestedFramePage nestedFramePage = new NestedFramePage(driver);
        nestedFramePage.interectWithNestedFrame();
    }
}