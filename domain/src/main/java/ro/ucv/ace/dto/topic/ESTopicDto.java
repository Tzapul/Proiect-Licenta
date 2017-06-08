package ro.ucv.ace.dto.topic;

/**
 * Created by tzapt on 11/26/2016.
 */
public class ESTopicDto {

    private String name;

    public ESTopicDto() {
    }

    public ESTopicDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
