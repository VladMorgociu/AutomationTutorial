package pages;

import loggerUtility.LoggerUtility;
import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends  BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private  WebElement submitElement;
    @FindBy(id = "edit-record-4")
    private WebElement updateElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;
    @FindBy(id = "submit")
    private WebElement editSubmit;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void addEntry(WebTableObject testData){
        elementMethods.clickElement(addElement);
        LoggerUtility.info("The user clicks the Add Button.");
        elementMethods.fillElement(firstNameElement, testData.getFirstNameElementValue());
        LoggerUtility.info("The user fills his first name.");
        elementMethods.fillElement(lastNameElement, testData.getLastNameElementValue());
        LoggerUtility.info("The user fills his last name.");
        elementMethods.fillElement(emailElement, testData.getUserEmailElementValue());
        LoggerUtility.info("The user fills his user email.");
        elementMethods.fillElement(ageElement, testData.getAgeElementValue());
        LoggerUtility.info("The user fills his age.");
        elementMethods.fillElement(salaryElement, testData.getSalaryElementValue());
        LoggerUtility.info("The user fills his salary.");
        elementMethods.fillElement(departmentElement, testData.getDepartmentElementValue());
        LoggerUtility.info("The user fills his department.");
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user clicks on submit.");
    }

    public void editEntry(WebTableObject testData){
        elementMethods.clickElement(updateElement);
        LoggerUtility.info("The user clicks the update button.");
        elementMethods.clearFillElement(editSalaryElement, testData.getEditSalaryElementValue());
        LoggerUtility.info("The user clears and refills the salary field.");
        elementMethods.clearFillElement(editDepartmentElement,testData.getEditDepartmentElementValue());
        LoggerUtility.info("The user clears and refills the department field.");
        elementMethods.clickElement(editSubmit);
        LoggerUtility.info("The user clicks on submit.");
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
        LoggerUtility.info("The user deletes the entry.");
    }
}
