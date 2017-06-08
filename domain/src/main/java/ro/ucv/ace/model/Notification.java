package ro.ucv.ace.model;

import ro.ucv.ace.visitor.NotificationVisitor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "SEEN")
    private Boolean seen;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    private Account account;

    public Notification() {
    }

    public Notification(String message) {
        this.message = message;
        this.date = LocalDateTime.now();
        this.seen = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void accept(NotificationVisitor visitor) {
        visitor.visit(this);
    }
}
