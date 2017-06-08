package ro.ucv.ace.dto.task;

public class STaskDto {

    private String name;

    private String description;

    private String deadline;

    private String language;

    private String[] subgroups;

    private String inputFile;

    private String outputFile;

    private boolean testsEnabled;

    private boolean plagiarismEnabled;

    public STaskDto() {
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

    public String[] getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(String[] subgroups) {
        this.subgroups = subgroups;
    }

    public boolean isTestsEnabled() {
        return testsEnabled;
    }

    public void setTestsEnabled(boolean testsEnabled) {
        this.testsEnabled = testsEnabled;
    }

    public boolean isPlagiarismEnabled() {
        return plagiarismEnabled;
    }

    public void setPlagiarismEnabled(boolean plagiarismEnabled) {
        this.plagiarismEnabled = plagiarismEnabled;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }
}

