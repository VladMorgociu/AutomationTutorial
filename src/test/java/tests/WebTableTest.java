package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest () {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.navigateToTableSubmenu();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addEntry("Vlad", "Morgociu", "vlad.morgociu@blabla.com", "28", "10000",
                "IT Support");
        webTablePage.editEntry("12000", "Call Center");
        webTablePage.deleteEntry();


    }
}