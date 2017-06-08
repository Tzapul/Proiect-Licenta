package ro.ucv.ace.dto.plagiarismResult;

/**
 * Created by tzapt on 12/10/2016.
 */
public class PlagiarismResultDto {

    private int id;

    private String username;

    private String firstName;

    private String lastName;

    private String gender;

    private String ssn;

    private String email;

    private String subgroup;

    private String similarityPercent;

    private String url;

    public PlagiarismResultDto() {
    }

    public PlagiarismResultDto(int id, String username, String firstName, String lastName, String gender, String ssn,
                               String email, String subgroup, String similarityPercent, String url) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.ssn = ssn;
        this.email = email;
        this.subgroup = subgroup;
        this.similarityPercent = similarityPercent;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSimilarityPercent() {
        return similarityPercent;
    }

    public void setSimilarityPercent(String similarityPercent) {
        this.similarityPercent = similarityPercent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
