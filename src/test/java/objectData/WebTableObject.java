package objectData;

public class WebTableObject extends GeneralObject {

    private String firstNameElementValue;
    private String lastNameElementValue;
    private String userEmailElementValue;
    private String ageElementValue;
    private String salaryElementValue;
    private String departmentElementValue;
    private String editSalaryElementValue;
    private String editDepartmentElementValue;

    public WebTableObject(String jsonPath) {
        fromJsonToObject(jsonPath);
    }

    public String getFirstNameElementValue() {
        return firstNameElementValue;
    }

    public void setFirstNameElementValue(String firstNameElementValue) {
        this.firstNameElementValue = firstNameElementValue;
    }

    public String getLastNameElementValue() {
        return lastNameElementValue;
    }

    public void setLastNameElementValue(String lastNameElementValue) {
        this.lastNameElementValue = lastNameElementValue;
    }

    public String getUserEmailElementValue() {
        return userEmailElementValue;
    }

    public void setUserEmailElementValue(String userEmailElementValue) {
        this.userEmailElementValue = userEmailElementValue;
    }

    public String getAgeElementValue() {
        return ageElementValue;
    }

    public void setAgeElementValue(String ageElementValue) {
        this.ageElementValue = ageElementValue;
    }

    public String getSalaryElementValue() {
        return salaryElementValue;
    }

    public void setSalaryElementValue(String salaryElementValue) {
        this.salaryElementValue = salaryElementValue;
    }

    public String getDepartmentElementValue() {
        return departmentElementValue;
    }

    public void setDepartmentElementValue(String departmentElementValue) {
        this.departmentElementValue = departmentElementValue;
    }

    public String getEditSalaryElementValue() {
        return editSalaryElementValue;
    }

    public void setEditSalaryElementValue(String editSalaryElementValue) {
        this.editSalaryElementValue = editSalaryElementValue;
    }

    public String getEditDepartmentElementValue() {
        return editDepartmentElementValue;
    }

    public void setEditDepartmentElementValue(String editDepartmentElementValue) {
        this.editDepartmentElementValue = editDepartmentElementValue;
    }
}

