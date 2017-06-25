package ro.ucv.ace.dto;

/**
 * Created by tzapt on 6/25/2017.
 */
public class TableDto {

    private int id;

    private String name;

    private int noOfPeople;

    public TableDto() {
    }

    public TableDto(String name, int noOfPeople) {
        this.name = name;
        this.noOfPeople = noOfPeople;
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

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }
}
