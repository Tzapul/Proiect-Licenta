package ro.ucv.ace.model;

import ro.ucv.ace.visitor.SubgroupVisitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "SUBGROUP")
public class Subgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false, unique = true)
    @Basic
    private String name;

    @OneToMany(mappedBy = "subgroup")
    private List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "subgroups")
    private List<Task> task = new ArrayList<>();

    public Subgroup() {
    }

    public Subgroup(String name) {
        this.name = name;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Task> getTasks() {
        return task;
    }

    public void setTasks(List<Task> task) {
        this.task = task;
    }

    public void accept(SubgroupVisitor visitor) {
        visitor.visit(this);
    }

    public void update(String name) {
        this.name = name;
    }
}
