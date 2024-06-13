package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest () {

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit url
        driver.get("https://demoqa.com/");

        //Maximizam dimensiunile browserului
        driver.manage().window().maximize();

        //Obiecte
        PageMethods pageMethods = new PageMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);

        //Facem scroll paginii pentru vizibilitate

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //Interactionam cu meniul/submeniul de pe site
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        //elementsMenu.click();
        elementMethods.clickElement(elementsMenu);

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        //webTableSubmenu.click();
        elementMethods.clickElement(webTableSubmenu);

        //Definim un element dupa ID
        //test 1: adaug un entry

        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        //addElement.click();
        elementMethods.clickElement(addElement);

        WebElement firstNameElement  = driver.findElement(By.id("firstName"));
        String firstNameValue = "Vlad";
        //firstNameElement.sendKeys(firstNameValue);
        elementMethods.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Morgociu";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailElementValue = "vlad.morgociu@gmail.com";
        //emailElement.sendKeys(emailElementValue);
        elementMethods.fillElement(emailElement, emailElementValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageElementValue = "27";
        //ageElement.sendKeys(ageElementValue);
        elementMethods.fillElement(ageElement, ageElementValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryElementValue = "10000";
        //salaryElement.sendKeys(salaryElementValue);
        elementMethods.fillElement(salaryElement, salaryElementValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentElementValue = "Support IT";
        //departmentElement.sendKeys(departmentElementValue);
        elementMethods.fillElement(departmentElement, departmentElementValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethods.clickElement(submitElement);

        //test 2: modific un entry existent
        WebElement updateElement = driver.findElement(By.id("edit-record-4"));
        //updateElement.click();
        elementMethods.clickElement(updateElement);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "12000";
        //editSalaryElement.clear();
        elementMethods.clearFillElement(editSalaryElement, editSalaryValue);
        //editSalaryElement.sendKeys(editSalaryValue);
        elementMethods.fillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentElementValue = "Call Center";
        //editDepartmentElement.clear();
        elementMethods.clearFillElement(editDepartmentElement,editDepartmentElementValue);
        //editDepartmentElement.sendKeys(editDepartmentElementValue);
        elementMethods.fillElement(editDepartmentElement, editDepartmentElementValue);

        WebElement editSubmit = driver.findElement(By.id("submit"));
        //editSubmit.click();
        elementMethods.clickElement(editSubmit);

        //test 3:stergem un entry
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        //deleteElement.click();
        elementMethods.clickElement(deleteElement);
        driver.quit();

    }

}
