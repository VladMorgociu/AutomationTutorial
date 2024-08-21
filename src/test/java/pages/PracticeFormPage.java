package pages;

import helperMethods.ElementMethods;
import loggerUtility.LoggerUtility;
import objectData.PracticeFormObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> genderElements;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthSelect;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearSelect;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    private List<WebElement> daySelect;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> hobbies;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "react-select-3-input")
    private WebElement selectState;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "react-select-4-input")
    private WebElement selectCity;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement thankYouMessage;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    private List<WebElement> tableValues;

    @FindBy(id = "closeLargeModal")
    private WebElement closeModal;

    public void fillEntireForm(PracticeFormObject testData){

        elementMethods.fillElement(firstName, testData.getFirstNameValue());
        LoggerUtility.info("The user fills his first name.");
        elementMethods.fillElement(lastName, testData.getLastNameValue());
        LoggerUtility.info("The user fills his last name.");
        elementMethods.fillElement(userEmail, testData.getUserEmailValue());
        LoggerUtility.info("The user fills his email address.");

        switch (testData.getGenderValue()) {
            case "Male":
                elementMethods.clickElement(genderElements.get(0));
                break;

            case "Female":
                elementMethods.clickElement(genderElements.get(1));
                break;

            case "Other":
                elementMethods.clickElement(genderElements.get(2));
                break;
        }
        LoggerUtility.info("The user selects the gender: " +testData.getGenderValue());

        userNumber.sendKeys(testData.getMobilePhoneValue());
        LoggerUtility.info("The user fills his mobile number.");
        elementMethods.clickElement(dateOfBirth);
        LoggerUtility.info("The user clicks the date of birth field.");
        elementMethods.selectByTextElement(monthSelect,"September");
        LoggerUtility.info("The user selects his birth month.");
        elementMethods.selectByValueElement(yearSelect,"1997");
        LoggerUtility.info("The user selects his birth year.");

        for (Integer index=0; index < daySelect.size(); index++) {
            if(daySelect.get(index).getText().equals(testData.getDateOfBirthDayValue())){
                //dateOfBirthDaysElement.get(index).click();
                elementMethods.clickElement(daySelect.get(index));
                break;
            }
        }
        LoggerUtility.info("The user submitted his birthdate.");

        elementMethods.fillElement(subjectsInput, testData.getSubjectInputValue());
        LoggerUtility.info("The user selected the subjects: " + testData.getSubjectInputValue());
        elementMethods.pressElement(subjectsInput, Keys.ENTER);
        LoggerUtility.info("The user submitted his choice.");


        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        for (Integer index = 0; index < hobbies.size(); index++) {
            String hobbyText = hobbies.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) {
                //hobbyElements.get(index).click();
                elementMethods.clickElement(hobbies.get(index));

            }
        }
        LoggerUtility.info("The user selected his hobbies: " + testData.getHobbiesValues());

        File file = new File("src/test/resources/" + testData.getPicturePathValue());
        uploadPicture.sendKeys(file.getAbsolutePath());
        LoggerUtility.info("The user uploaded a picture.");

        elementMethods.fillElement(currentAddress, testData.getAddressValue());
        LoggerUtility.info("The user fills his address.");
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page.");
        elementMethods.clickElement(state);
        LoggerUtility.info("The user clicks on the state field.");
        elementMethods.fillElement(selectState, testData.getStateInputValue());
        LoggerUtility.info("The user fills his state.");
        elementMethods.pressElement(selectState, Keys.ENTER);
        LoggerUtility.info("The user submits his state.");
        elementMethods.clickElement(city);
        LoggerUtility.info("The user clicks the city field.");
        elementMethods.fillElement(selectCity, testData.getCityInputValue());
        LoggerUtility.info("The user fills his city.");
        elementMethods.pressElement(selectCity, Keys.ENTER);
        LoggerUtility.info("The user submits his state.");
        elementMethods.clickElement(submit);
        LoggerUtility.info("The user submits all his selections.");
    }

    public void validateEntireForm(PracticeFormObject testData){
        elementMethods.waitForElementVisible(thankYouMessage);
        Assert.assertEquals(thankYouMessage.getText(), "Thank you for submitting the form!");
        LoggerUtility.info("The user validates the presence of " + thankYouMessage.getText() + ".");
        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + testData.getFirstNameValue() + " " + testData.getLastNameValue());
        LoggerUtility.info("The user validated the presence of " + testData.getFirstNameValue() + " " + testData.getLastNameValue() + ".");
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + testData.getUserEmailValue());
        LoggerUtility.info("The user validated the presence of " + testData.getUserEmailValue() + ".");
        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + testData.getGenderValue());
        LoggerUtility.info("The user validated the presence of " + testData.getGenderValue() + ".");
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + testData.getMobilePhoneValue());
        LoggerUtility.info("The user validated the presence of " + testData.getMobilePhoneValue() + ".");
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + testData.getSubjectInputValue());
        LoggerUtility.info("The user validated the presence of " + testData.getSubjectInputValue() + ".");
        String expectedHobbiesText = "Hobbies " + String.join(", ", testData.getHobbiesValues());
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        LoggerUtility.info("The user validated the presence of " + testData.getHobbiesValues() + ".");
        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + testData.getPicturePathValue());
        LoggerUtility.info("The user validated the presence of " + testData.getPicturePathValue() + ".");
        Assert.assertEquals(tableValues.get(8).getText(), "Address " + testData.getAddressValue());
        LoggerUtility.info("The user validated the presence of " + testData.getAddressValue() + ".");
        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + testData.getStateInputValue() + " " + testData.getCityInputValue());
        LoggerUtility.info("The user validated the presence of state " + testData.getStateInputValue() + " and city " + testData.getCityInputValue() + ".");

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        elementMethods.clickElement(closeElement);

    }

}