package ro.ucv.ace.dto.student;

/**
 * Created by tzapt on 11/20/2016.
 */
public class ESStudentDto {

    private String firstName;

    private String lastName;

    private String gender;

    private String ssn;

    private String email;

    private String subgroup;

    public ESStudentDto() {

    }

    public ESStudentDto(String firstName, String lastName, String gender, String ssn, String email, String subgroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.ssn = ssn;
        this.email = email;
        this.subgroup = subgroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }
}
