package bean;

import com.squareup.moshi.Json;

import java.util.List;

public class City {

    private String name;

    @Json(name = "children")
    private List<Area> areas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
