package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest () {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();

        String firstNameValue = "Vlad";
        String lastNameValue = "Morgociu";
        String userEmailValue = "vlad.morgociu@blabla.com";
        String genderValue = "Female"; 
        String mobilePhoneValue = "0712345678";
        String dateOfBirthDayValue = "20";
        String subjectInputValue = "Accounting";
        String hobbiesValues = "Sports, Music";
        String picturePathValue = "Test.txt";
        String addressValue = "Strada Exemplu Nr. 1";
        String stateInputValue = "NCR";
        String cityInputValue = "Delhi";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue,lastNameValue,userEmailValue,genderValue,mobilePhoneValue,
                dateOfBirthDayValue,subjectInputValue,picturePathValue,addressValue,stateInputValue,cityInputValue);

        practiceFormPage.validateEntireForm(firstNameValue, lastNameValue,userEmailValue,genderValue,mobilePhoneValue,dateOfBirthDayValue,
                subjectInputValue,hobbiesValues ,picturePathValue,addressValue,stateInputValue,cityInputValue);

    }
}
