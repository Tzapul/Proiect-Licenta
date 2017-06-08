package ro.ucv.ace.model;

import ro.ucv.ace.model.enums.Gender;
import ro.ucv.ace.model.enums.UserRole;
import ro.ucv.ace.visitor.ProfessorVisitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "PROFESSOR")
public class Professor extends User {

    @Column(name = "POSITION", nullable = false)
    @Basic
    private String position;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.REMOVE)
    private List<Topic> topics = new ArrayList<>();

    public Professor() {

    }

    public Professor(String firstName, String gender, String lastName, String position, String ssn, String email, String username, String password) {
        PersonDetails personDetails = new PersonDetails(firstName, lastName, ssn, gender);
        Account account = new Account(email, username, password, UserRole.PROFESSOR, this);
        this.setAccount(account);
        this.setPersonDetails(personDetails);
        this.position = position;
    }

    public Professor(int professorId) {
        this.setId(professorId);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void accept(ProfessorVisitor visitor) {
        visitor.visit(this);
    }

    public void update(String firstName, String lastName, String ssn, String email, String gender, String position) {
        this.getPersonDetails().setFirstName(firstName);
        this.getPersonDetails().setLastName(lastName);
        this.getPersonDetails().setSsn(ssn);
        this.getPersonDetails().setGender(Gender.valueOf(gender));
        this.setPosition(position);
        this.getAccount().setEmail(email);
    }

    public boolean hasTopicWithName(String name) {
        topics.size();
        for (Topic topic : topics) {
            if (topic.hasName(name)) {
                return true;
            }
        }

        return false;
    }


    public boolean hasTaskWithNameInTopicWithId(String name, int topicId) {
        topics.size();
        Topic searched = null;
        for (Topic topic : topics) {
            if (topic.hasId(topicId)) {
                searched = topic;
                break;
            }
        }

        return searched.hasTaskWithName(name);
    }
}
