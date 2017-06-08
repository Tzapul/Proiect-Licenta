package ro.ucv.ace.dto.studentGrade;

/**
 * Created by tzapt on 12/10/2016.
 */
public class ESStudentGradeDto {

    private Double mark;

    public ESStudentGradeDto() {
    }

    public ESStudentGradeDto(Double mark) {
        this.mark = mark;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
