package ro.ucv.ace.model;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import ro.ucv.ace.builder.INotificationBuilder;
import ro.ucv.ace.dto.other.ResponseMessageDto;
import ro.ucv.ace.model.enums.Language;
import ro.ucv.ace.socket.ISocketManager;
import ro.ucv.ace.visitor.StudentTaskVisitor;
import ro.ucv.ace.visitor.TaskVisitor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "TASK")
@Inheritance(strategy = InheritanceType.JOINED)
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public abstract class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @Basic
    private String name;

    @Column(name = "DESCRIPTION")
    @Basic
    private String description;

    @Column(name = "DEADLINE")
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    @Column(name = "LANGUAGE")
    private Language language;

    @Column(name = "PATH")
    @Basic
    private String path;

    @Column(name = "ANALYZED")
    @Basic
    private boolean analyzed = false;

    @ManyToOne
    @JoinColumn(name = "PLAGIARISM_ANALYSER_ID")
    private PlagiarismAnalyser plagiarismAnalyser;

    @ManyToOne
    @JoinColumn(name = "TOPIC_ID", referencedColumnName = "ID")
    private Topic topic;

    @ManyToMany
    @JoinTable(name = "TASK_SUBGROUP", joinColumns = @JoinColumn(name = "TASK_ID", referencedColumnName = "ID")
            , inverseJoinColumns = @JoinColumn(name = "SUBGROUP_ID", referencedColumnName = "ID"))
    private List<Subgroup> subgroups = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Solution> solutions = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<PlagiarismResult> plagiarismResults = new ArrayList<>();


    @Autowired
    @Transient
    protected ISocketManager socketManager;

    @Autowired
    @Transient
    protected INotificationBuilder notificationBuilder;

    public List<PlagiarismResult> getPlagiarismResults() {
        return plagiarismResults;
    }

    public void setPlagiarismResults(List<PlagiarismResult> plagiarismResults) {
        this.plagiarismResults = plagiarismResults;
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    public void setAnalyzed(boolean analyzed) {
        this.analyzed = analyzed;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isCanSubmitSolutions() {
        return this.deadline.isAfter(LocalDate.now());
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public List<Subgroup> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(List<Subgroup> subgroups) {
        this.subgroups = subgroups;
    }

    public PlagiarismAnalyser getPlagiarismAnalyser() {
        return plagiarismAnalyser;
    }

    public void setPlagiarismAnalyser(PlagiarismAnalyser plagiarismAnalyser) {
        this.plagiarismAnalyser = plagiarismAnalyser;
    }

    public void accept(TaskVisitor visitor) {
        visitor.visit(this);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public void update(String name, String description, LocalDate localDate, PlagiarismAnalyser plagiarismAnalyser) {
        setName(name);
        setDescription(description);
        setDeadline(localDate);
        setPlagiarismAnalyser(plagiarismAnalyser);
    }

    public abstract boolean hasTestsEnabled();

    public abstract boolean hasPlagiarismAnalyserEnabled();

    public abstract ResponseMessageDto addSolution(Solution solution);

    public Solution getSolutionByStudent(int studentId) {
        for (Solution solution : solutions) {
            if (solution.getStudent().getId().equals(studentId)) {
                return solution;
            }
        }

        throw new ro.ucv.ace.exception.EntityNotFoundException("Solution not found");
    }

    public void accept(StudentTaskVisitor studentTaskVisitor, String mark, boolean solutionSent) {
        studentTaskVisitor.visit(this, mark, solutionSent);
    }
}
