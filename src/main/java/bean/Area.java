package bean;

import com.squareup.moshi.Json;

import java.util.List;

public class Area {

    private String name;

    @Json(name = "children")
    private List<Street> streets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
}
