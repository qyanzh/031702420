package utils;

import bean.Area;
import bean.City;
import bean.Province;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    private static List<Province> provinces;

    private static List<City> cities;

    private static List<Area> areas;

    public static void build() {
        String filePath = "/pcas-code.json";
        InputStream inputStream = DataUtil.class.getResourceAsStream(filePath);
        StringBuilder json = new StringBuilder();
        FileUtil.convertFileToStringList(inputStream).forEach(json::append);
        try {
            DataUtil.provinces = JsonUtil.getProvincesFromJson(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Province> getProvinces() {
        if (provinces == null) {
            build();
        }
        return provinces;
    }

    public static List<City> getCities() {
        if (cities == null) {
            cities = new ArrayList<>();
            getProvinces().forEach(p ->
                    cities.addAll(p.getCities())
            );
        }
        return cities;
    }

    public static List<Area> getAreas() {
        if (areas == null) {
            areas = new ArrayList<>();
            getCities().forEach(c ->
                    areas.addAll(c.getAreas())
            );
        }
        return areas;
    }

}
