package ro.ucv.ace.model;

import ro.ucv.ace.model.enums.Gender;
import ro.ucv.ace.model.enums.UserRole;
import ro.ucv.ace.visitor.StudentGradeVisitor;
import ro.ucv.ace.visitor.StudentVisitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "STUDENT")
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "SUBGROUP_ID", referencedColumnName = "ID")
    private Subgroup subgroup;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Solution> solutions = new ArrayList<>();


    public Student() {

    }

    public Student(String firstName, String lastName, String email, String ssn, String gender, String username, String password,
                   Subgroup subgroup) {
        PersonDetails personDetails = new PersonDetails(firstName, lastName, ssn, gender);
        Account account = new Account(email, username, password, UserRole.STUDENT, this);
        this.setSubgroup(subgroup);
        this.setAccount(account);
        this.setPersonDetails(personDetails);
    }

    public Subgroup getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroup subgroup) {
        this.subgroup = subgroup;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }

    public void update(String firstName, String lastName, String ssn, String email, String gender, Subgroup subgroup) {
        this.getPersonDetails().setFirstName(firstName);
        this.getPersonDetails().setLastName(lastName);
        this.getPersonDetails().setSsn(ssn);
        this.getPersonDetails().setGender(Gender.valueOf(gender));
        this.getAccount().setEmail(email);
        this.setSubgroup(subgroup);
    }

    public void accept(StudentGradeVisitor studentGradeVisitor) {
        studentGradeVisitor.visit(this);
    }
}
