package ro.ucv.ace.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Geo on 30.11.2016.
 */
@Entity
@Table(name = "DEFAULT_PLAGIARISM_ANALYSER")
@DiscriminatorValue("DPA")
public class DefaultPlagiarismAnalyser extends PlagiarismAnalyser {
    @Override
    public boolean isEnabled() {
        return true;
    }
}
