package ro.ucv.ace.dto.notification;

/**
 * Created by Geo on 07.12.2016.
 */
public class NotificationDto {

    private int id;

    private String message;

    private String date;

    private boolean seen;

    public NotificationDto() {
    }

    public NotificationDto(int id, String message, String date, boolean seen) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.seen = seen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
