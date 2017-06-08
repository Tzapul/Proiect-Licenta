package ro.ucv.ace.dto.solution;

/**
 * Created by tzapt on 12/4/2016.
 */
public class SolutionDto {

    private int id;

    private double mark;

    private String directoryPath;

    public SolutionDto() {
    }

    public SolutionDto(int id, double mark, String directoryPath) {
        this.id = id;
        this.mark = mark;
        this.directoryPath = directoryPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }
}
