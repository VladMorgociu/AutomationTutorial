package pages;

import helperMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departmentElement;
    @FindBy(id = "submit")
    public  WebElement submitElement;
    @FindBy(id = "edit-record-4")
    public WebElement updateElement;
    @FindBy(id = "salary")
    public WebElement editSalaryElement;
    @FindBy(id = "department")
    public WebElement editDepartmentElement;
    @FindBy(id = "submit")
    public WebElement editSubmit;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void addEntry(String firstNameValue, String lastNameValue, String emailElementValue, String ageElementValue, String salaryElementValue,
                         String departmentElementValue){
        elementMethods.clickElement(addElement);
        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(emailElement, emailElementValue);
        elementMethods.fillElement(ageElement, ageElementValue);
        elementMethods.fillElement(salaryElement, salaryElementValue);
        elementMethods.fillElement(departmentElement, departmentElementValue);
        elementMethods.clickElement(submitElement);
    }

    public void editEntry(String editSalaryValue, String editDepartmentElementValue){
        elementMethods.clickElement(updateElement);
        elementMethods.clearFillElement(editSalaryElement, editSalaryValue);
        elementMethods.fillElement(editSalaryElement, editSalaryValue);
        elementMethods.clearFillElement(editDepartmentElement,editDepartmentElementValue);
        elementMethods.fillElement(editDepartmentElement, editDepartmentElementValue);
        elementMethods.clickElement(editSubmit);
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
    }
}
