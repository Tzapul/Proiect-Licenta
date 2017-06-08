package ro.ucv.ace.dto.subgroup;

/**
 * Created by Geo on 19.11.2016.
 */
public class SubgroupDto {

    private Integer id;

    private String name;

    public SubgroupDto() {
    }

    public SubgroupDto(Integer id, String name) {

        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
