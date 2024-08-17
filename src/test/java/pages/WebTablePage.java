package pages;

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
        elementMethods.fillElement(firstNameElement, testData.getFirstNameElementValue());
        elementMethods.fillElement(lastNameElement, testData.getLastNameElementValue());
        elementMethods.fillElement(emailElement, testData.getUserEmailElementValue());
        elementMethods.fillElement(ageElement, testData.getAgeElementValue());
        elementMethods.fillElement(salaryElement, testData.getSalaryElementValue());
        elementMethods.fillElement(departmentElement, testData.getDepartmentElementValue());
        elementMethods.clickElement(submitElement);
    }

    public void editEntry(WebTableObject testData){
        elementMethods.clickElement(updateElement);
        elementMethods.clearFillElement(editSalaryElement, testData.getEditSalaryElementValue());
        elementMethods.clearFillElement(editDepartmentElement,testData.getEditDepartmentElementValue());
        elementMethods.clickElement(editSubmit);
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
    }
}
