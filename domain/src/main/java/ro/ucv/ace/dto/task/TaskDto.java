package ro.ucv.ace.dto.task;

/**
 * Created by tzapt on 11/26/2016.
 */
public class TaskDto {

    private Integer id;

    private String name;

    private String description;

    private String deadline;

    private String language;

    private boolean canSubmitSolutions;

    private boolean testsEnabled;

    private boolean plagiarismAnalyserEnabled;

    private int sentSolutions;

    private int noStudents;

    private String[] subgroups;

    public TaskDto(Integer id, String name, String description, String deadline, String language,
                   boolean canSubmitSolutions, boolean testsEnabled, boolean plagiarismAnalyserEnabled, int sentSolutions,
                   int noStudents, String[] subgroups) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.language = language;
        this.canSubmitSolutions = canSubmitSolutions;
        this.testsEnabled = testsEnabled;
        this.plagiarismAnalyserEnabled = plagiarismAnalyserEnabled;
        this.sentSolutions = sentSolutions;
        this.noStudents = noStudents;
        this.subgroups = subgroups;
    }

    public String[] getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(String[] subgroups) {
        this.subgroups = subgroups;
    }

    public int getSentSolutions() {
        return sentSolutions;
    }

    public void setSentSolutions(int sentSolutions) {
        this.sentSolutions = sentSolutions;
    }

    public int getNoStudents() {
        return noStudents;
    }

    public void setNoStudents(int noStudents) {
        this.noStudents = noStudents;
    }

    public boolean isTestsEnabled() {
        return testsEnabled;
    }

    public void setTestsEnabled(boolean testsEnabled) {
        this.testsEnabled = testsEnabled;
    }

    public boolean isPlagiarismAnalyserEnabled() {
        return plagiarismAnalyserEnabled;
    }

    public void setPlagiarismAnalyserEnabled(boolean plagiarismAnalyserEnabled) {
        this.plagiarismAnalyserEnabled = plagiarismAnalyserEnabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isCanSubmitSolutions() {
        return canSubmitSolutions;
    }

    public void setCanSubmitSolutions(boolean canSubmitSolutions) {
        this.canSubmitSolutions = canSubmitSolutions;
    }
}
