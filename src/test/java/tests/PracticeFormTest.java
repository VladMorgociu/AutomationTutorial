package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
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
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);


        //Facem scroll paginii pentru vizibilitate

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);


        //Interactionam cu meniul/submeniul de pe site
        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //formMenu.click();
        elementMethods.clickElement(formMenu);

        WebElement practiceFormSubmenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        //practiceFormSubmenu.click();
        elementMethods.clickElement(practiceFormSubmenu);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Vlad";
        //firstNameElement.sendKeys(firstNameValue);
        elementMethods.fillElement(firstNameElement, firstNameValue);


        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Morgociu";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "vlad.morgociu@blabla.com";
        //userEmailElement.sendKeys(userEmailValue);
        elementMethods.fillElement(userEmailElement, userEmailValue);


        //definim o metoda generala de a selecta un element dintr-o lista
        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue = "Female";
        switch (genderValue) {
            case "Male":
                //genderElements.get(0).click();
                elementMethods.clickElement(genderElements.get(0));
                break;

            case "Female":
                //genderElements.get(1).click();
                elementMethods.clickElement(genderElements.get(1));
                break;

            case "Other":
                //genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));
                break;
        }

        WebElement mobilePhoneElement = driver.findElement(By.id("userNumber"));
        String mobilePhoneValue = "0712345678";
        mobilePhoneElement.sendKeys(mobilePhoneValue);

        //Date of Birth - Dropdown list
        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        //dateOfBirthElement.click();
        elementMethods.clickElement(dateOfBirthElement);

        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dateOfBirthMonthElement);
        //monthSelect.selectByVisibleText("September");
        elementMethods.selectByTextElement(dateOfBirthMonthElement,"September");

        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
       //Select yearSelect = new Select(dateOfBirthYearElement);
       //yearSelect.selectByValue("1997");
        elementMethods.selectByValueElement(dateOfBirthYearElement,"1997");

        List<WebElement> dateOfBirthDaysElement = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']"));
        String dateOfBirthDayValue = "20";
        for (Integer index=0; index < dateOfBirthDaysElement.size(); index++) {
            if(dateOfBirthDaysElement.get(index).getText().equals(dateOfBirthDayValue)){
                //dateOfBirthDaysElement.get(index).click();
                elementMethods.clickElement(dateOfBirthDaysElement.get(index));
                break;
            }
        }

        //subjectsInput
        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
        String subjectInputValue = "Accounting";
        //subjectInputElement.sendKeys(subjectInputValue);
        //subjectInputElement.sendKeys(Keys.ENTER);
        elementMethods.fillElement(subjectInputElement, subjectInputValue);
        elementMethods.pressElement(subjectInputElement, Keys.ENTER);


        List<WebElement> hobbyElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        for (Integer index = 0; index < hobbyElements.size(); index++) {
            String hobbyText = hobbyElements.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) {
                //hobbyElements.get(index).click();
                elementMethods.clickElement(hobbyElements.get(index));

            }
        }

        //Interactionam cu un fisier
        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        String picturePathValue = "Test.txt";
        File file = new File("src/test/resources/" + picturePathValue);
        pictureElement.sendKeys(file.getAbsolutePath());


        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "Strada Exemplu Nr. 1";
        //addressElement.sendKeys(addressValue);
        elementMethods.fillElement(addressElement, addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        //stateElement.click();
        elementMethods.clickElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "NCR";
        //stateInputElement.sendKeys(stateInputValue);
        elementMethods.fillElement(stateInputElement, stateInputValue);
        //stateInputElement.sendKeys(Keys.ENTER);
        elementMethods.pressElement(stateInputElement, Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        //cityElement.click();
        elementMethods.clickElement(cityElement);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Delhi";
        //cityInputElement.sendKeys(cityInputValue);
        elementMethods.fillElement(cityInputElement, cityInputValue);
        //cityInputElement.sendKeys(Keys.ENTER);
        elementMethods.pressElement(cityInputElement, Keys.ENTER);

        //submit
        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethods.clickElement(submitElement);

        //validam tabelul cu valorile introduse
        WebElement thankYouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");


        //table[@class='table table-dark table-stripped table-bordered table-hover/tbody/tr
        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);

        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + userEmailValue);

        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);

        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + mobilePhoneValue);

        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectInputValue);

        //Assert.assertEquals(tableValues.get(6).getText(), "Hobbies " + hobbiesValues);
        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);

        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + picturePathValue);

        Assert.assertEquals(tableValues.get(8).getText(), "Address " + addressValue);

        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        elementMethods.clickElement(closeElement);
    }
}
