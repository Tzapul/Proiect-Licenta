package ro.ucv.ace.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 30.11.2016.
 */
@Entity
@Table(name = "PLAGIARISM_ANALYSER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("PA")
public abstract class PlagiarismAnalyser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToMany(mappedBy = "plagiarismAnalyser")
    private List<Task> tasks = new ArrayList<>();

    public abstract boolean isEnabled();
}
