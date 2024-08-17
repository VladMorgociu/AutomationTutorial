package objectData;

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

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getUserEmailValue() {
        return userEmailValue;
    }

    public void setUserEmailValue(String userEmailValue) {
        this.userEmailValue = userEmailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getMobilePhoneValue() {
        return mobilePhoneValue;
    }

    public void setMobilePhoneValue(String mobilePhoneValue) {
        this.mobilePhoneValue = mobilePhoneValue;
    }

    public String getDateOfBirthDayValue() {
        return dateOfBirthDayValue;
    }

    public void setDateOfBirthDayValue(String dateOfBirthDayValue) {
        this.dateOfBirthDayValue = dateOfBirthDayValue;
    }

    public String getHobbiesValues() {
        return hobbiesValues;
    }

    public void setHobbiesValues(String hobbiesValues) {
        this.hobbiesValues = hobbiesValues;
    }

    public String getSubjectInputValue() {
        return subjectInputValue;
    }

    public void setSubjectInputValue(String subjectInputValue) {
        this.subjectInputValue = subjectInputValue;
    }

    public String getPicturePathValue() {
        return picturePathValue;
    }

    public void setPicturePathValue(String picturePathValue) {
        this.picturePathValue = picturePathValue;
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public String getStateInputValue() {
        return stateInputValue;
    }

    public void setStateInputValue(String stateInputValue) {
        this.stateInputValue = stateInputValue;
    }

    public String getCityInputValue() {
        return cityInputValue;
    }

    public void setCityInputValue(String cityInputValue) {
        this.cityInputValue = cityInputValue;
    }
}
