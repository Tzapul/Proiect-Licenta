package ro.ucv.ace.model;

import ro.ucv.ace.visitor.PlagiarismResultVisitor;

import javax.persistence.*;

/**
 * Created by Geo on 04.12.2016.
 */
@Entity
@Table(name = "PLAGIARISM_RESULT")
public class PlagiarismResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "STUDENT1_ID", referencedColumnName = "ID")
    private Student student1;

    @ManyToOne
    @JoinColumn(name = "STUDENT2_ID", referencedColumnName = "ID")
    private Student student2;

    @Column(name = "URL")
    @Basic
    private String url;

    @Column(name = "SIMILARITY_PERCENT")
    @Basic
    private float similarityPercent;

    @ManyToOne
    @JoinColumn(name = "TASK_ID", referencedColumnName = "ID")
    private Task task;

    public PlagiarismResult() {
    }

    public PlagiarismResult(Task task, Student student1, Student student2, String url, float similarityPercent) {
        this.student1 = student1;
        this.student2 = student2;
        this.url = url;
        this.similarityPercent = similarityPercent;
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public void setStudent2(Student student2) {
        this.student2 = student2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getSimilarityPercent() {
        return similarityPercent;
    }

    public void setSimilarityPercent(float similarityPercent) {
        this.similarityPercent = similarityPercent;
    }

    public void accept(PlagiarismResultVisitor plagiarismResultVisitor) {
        plagiarismResultVisitor.visit(this);
    }
}
