package ro.ucv.ace.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Geo on 30.11.2016.
 */
@Entity
@Table(name = "NULL_PLAGIARISM_ANALYSER")
@DiscriminatorValue("NPA")
public class NullPlagiarismAnalyser extends PlagiarismAnalyser {
    @Override
    public boolean isEnabled() {
        return false;
    }
}
