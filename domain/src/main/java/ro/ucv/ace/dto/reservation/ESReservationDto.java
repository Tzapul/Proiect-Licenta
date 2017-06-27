package ro.ucv.ace.dto.reservation;

/**
 * Created by tzapt on 6/15/2017.
 */
public class ESReservationDto {

    private String name;

    private String email;

    private String date;

    private int hour;

    private String phone;

    private int people;

    public ESReservationDto() {
    }

    public ESReservationDto(String name, String email, String date, int hour, String phone, int people) {
        this.name = name;
        this.email = email;
        this.date = date;
        this.hour = hour;
        this.phone = phone;
        this.people = people;
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
