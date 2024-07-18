package tests;

import helperMethods.PageMethods;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void metodaTest() {

        PageMethods pageMethods = new PageMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToAlertsMenu();
        pageMethods.scrollPage(0, 350);

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToFramePage();

        FramePage framePage = new FramePage(getDriver());
        framePage.interactWithBigFrame();
        framePage.interactWithSmallFrame();
        framePage.navigateToNestedFrames();

        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.interectWithNestedFrame();
    }
}