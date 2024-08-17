package objectData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PracticeFormObject extends GeneralObject{

    private String firstNameValue = "Vlad";
    private String lastNameValue = "Morgociu";
    private String userEmailValue = "vlad.morgociu@blabla.com";
    private String genderValue = "Female";
    private String mobilePhoneValue = "0712345678";
    private String dateOfBirthDayValue = "20";
    private String subjectInputValue = "Accounting";
    private String hobbiesValues = "Sports, Music";
    private String picturePathValue = "Test.txt";
    private String addressValue = "Strada Exemplu Nr. 1";
    private String stateInputValue = "NCR";
    private String cityInputValue = "Delhi";

    public PracticeFormObject(String filePath) {
        fromJsonToObject(filePath);
    }
}
