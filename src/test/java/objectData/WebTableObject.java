package objectData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}

