package ro.ucv.ace.model;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.ucv.ace.model.enums.UserRole;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "ACCOUNT")
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public class Account {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    @Basic
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    @Basic
    private String password;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Basic
    private String email;

    @JoinColumn(name = "ID")
    @OneToOne
    @MapsId
    private User user;

    @Autowired
    @Transient
    private PasswordEncoder passwordEncoder;

    public Account() {

    }

    public Account(String email, String username, String password, User user) {
        this.email = email;
        this.username = username;
        this.password = passwordEncoder.encode(password);
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email;
    }

    public User getClient() {
        return user;
    }

    public void setClient(User user) {
        this.user = user;
    }

    public boolean passwordMatches(String password) {
        return passwordEncoder.matches(password, getPassword());
    }
}
