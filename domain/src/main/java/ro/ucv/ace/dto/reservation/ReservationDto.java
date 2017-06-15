package ro.ucv.ace.dto.reservation;

/**
 * Created by tzapt on 6/15/2017.
 */
public class ReservationDto {

    private int id;

    private String name;

    private String email;

    private String date;

    private String phone;

    private int people;

    public ReservationDto(int id, String name, String email, String date, String phone, int people) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.phone = phone;
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
