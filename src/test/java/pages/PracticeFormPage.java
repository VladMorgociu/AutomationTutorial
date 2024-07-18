package pages;

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

    public void fillEntireForm(String firstNameValue, String lastNameValue,String userEmailValue,String genderValue,
                               String mobilePhoneValue,String dateOfBirthDayValue,String subjectInputValue,String picturePathValue,
                               String addressValue,String stateInputValue,String cityInputValue){

        elementMethods.fillElement(firstName, firstNameValue);
        elementMethods.fillElement(lastName, lastNameValue);
        elementMethods.fillElement(userEmail, userEmailValue);

        switch (genderValue) {
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

        userNumber.sendKeys(mobilePhoneValue);
        elementMethods.clickElement(dateOfBirth);
        elementMethods.selectByTextElement(monthSelect,"September");
        elementMethods.selectByValueElement(yearSelect,"1997");

        for (Integer index=0; index < daySelect.size(); index++) {
            if(daySelect.get(index).getText().equals(dateOfBirthDayValue)){
                //dateOfBirthDaysElement.get(index).click();
                elementMethods.clickElement(daySelect.get(index));
                break;
            }
        }

        elementMethods.fillElement(subjectsInput, subjectInputValue);
        elementMethods.pressElement(subjectsInput, Keys.ENTER);


        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        for (Integer index = 0; index < hobbies.size(); index++) {
            String hobbyText = hobbies.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) {
                //hobbyElements.get(index).click();
                elementMethods.clickElement(hobbies.get(index));

            }
        }

        File file = new File("src/test/resources/" + picturePathValue);
        uploadPicture.sendKeys(file.getAbsolutePath());

        elementMethods.fillElement(currentAddress, addressValue);
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(state);
        elementMethods.fillElement(selectState, stateInputValue);
        elementMethods.pressElement(selectState, Keys.ENTER);
        elementMethods.clickElement(city);
        elementMethods.fillElement(selectCity, cityInputValue);
        elementMethods.pressElement(selectCity, Keys.ENTER);
        elementMethods.clickElement(submit);
    }

    public void validateEntireForm(String firstNameValue, String lastNameValue,String userEmailValue, String genderValue,
                                   String mobilePhoneValue,String dateOfBirthValue, String subjectInputValue, String hobbiesValues, String picturePathValue,
                                   String addressValue, String stateInputValue, String cityInputValue){

        Assert.assertEquals(thankYouMessage.getText(), "Thanks for submitting the form");

        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);

        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + userEmailValue);

        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);

        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + mobilePhoneValue);

        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectInputValue);

        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);

        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + picturePathValue);

        Assert.assertEquals(tableValues.get(8).getText(), "Address " + addressValue);

        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        elementMethods.clickElement(closeElement);
    }

}