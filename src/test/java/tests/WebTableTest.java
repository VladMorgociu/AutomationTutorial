package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest () {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.navigateToTableSubmenu();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addEntry("Vlad", "Morgociu", "vlad.morgociu@blabla.com", "28", "10000",
                "IT Support");
        webTablePage.editEntry("12000", "Call Center");
        webTablePage.deleteEntry();

        driver.quit();
    }
}