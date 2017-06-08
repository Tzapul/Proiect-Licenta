package ro.ucv.ace.dto.task;

/**
 * Created by Geo on 11.12.2016.
 */
public class StudentTaskDto {

    private Integer id;

    private String name;

    private String description;

    private String deadline;

    private String language;

    private boolean testsEnabled;

    private String mark;

    private boolean solutionSent;

    public StudentTaskDto(Integer id, String name, String description, String deadline, String language,
                          boolean testsEnabled, String mark, boolean solutionSent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.language = language;
        this.testsEnabled = testsEnabled;
        this.mark = mark;
        this.solutionSent = solutionSent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSolutionSent() {
        return solutionSent;
    }

    public void setSolutionSent(boolean solutionSent) {
        this.solutionSent = solutionSent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isTestsEnabled() {
        return testsEnabled;
    }

    public void setTestsEnabled(boolean testsEnabled) {
        this.testsEnabled = testsEnabled;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
