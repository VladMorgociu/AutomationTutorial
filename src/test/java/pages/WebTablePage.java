package pages;

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
