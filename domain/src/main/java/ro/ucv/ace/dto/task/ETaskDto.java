package ro.ucv.ace.dto.task;

/**
 * Created by Geo on 01.12.2016.
 */
public class ETaskDto {

    private String deadline;

    private String description;

    private String inputFile;

    private String outputFile;

    private boolean filesUpdated;

    private String name;

    private boolean plagiarismEnabled;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isFilesUpdated() {
        return filesUpdated;
    }

    public void setFilesUpdated(boolean filesUpdated) {
        this.filesUpdated = filesUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlagiarismEnabled() {
        return plagiarismEnabled;
    }

    public void setPlagiarismEnabled(boolean plagiarismEnabled) {
        this.plagiarismEnabled = plagiarismEnabled;
    }
}
