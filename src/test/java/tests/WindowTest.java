package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit url
        driver.get("https://demoqa.com/");

        //Maximizam dimensiunile browserului
        driver.manage().window().maximize();

        //Definim un obiect de tipul WindowMethods
        WindowMethods windowMethods= new WindowMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);


        //Facem scroll paginii pentru vizibilitate

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);


        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //elementsMenu.click();
        elementMethods.clickElement(elementsMenu);

        WebElement browserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindows.click();

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

        // Interactionam cu un tab/window
        System.out.println(driver.getCurrentUrl());
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());



        //Ne mutam cu focusul pe un alt tab
        //driver.switchTo().window(tabs.get(1));
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        //Inchidem tab-ul curent
        //driver.close();
        windowMethods.closeCurrentTab();


        //driver.switchTo().window(tabs.get(0));
        windowMethods.switchSpecificTab(0);
        System.out.println(driver.getCurrentUrl());

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();

        //List<String> window = new ArrayList<>(driver.getWindowHandles());

        //Ne mutam cu focusul pe un alt tab
       // driver.switchTo().window(window.get(1));
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        //driver.close();
        windowMethods.closeCurrentTab();
        driver.quit();
 }
}
