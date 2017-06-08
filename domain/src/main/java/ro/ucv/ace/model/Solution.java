package ro.ucv.ace.model;

import ro.ucv.ace.visitor.SolutionVisitor;

import javax.persistence.*;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "SOLUTION")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MARK")
    @Basic
    private Double mark;

    @Column(name = "DIRECTORY_PATH", unique = true)
    @Basic
    private String directoryPath;

    @Column(name = "ACCEPTED")
    @Basic
    private boolean accepted = false;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "TASK_ID", referencedColumnName = "ID")
    private Task task;

    public Solution() {
    }

    public Solution(Student student, Task task, String stringPath) {
        setStudent(student);
        setTask(task);
        setDirectoryPath(stringPath);
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void accept(SolutionVisitor solutionVisitor) {
        solutionVisitor.visit(this);
    }
}
