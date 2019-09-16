import bean.Province;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Data {

    private static List<Province> provinces;

    public static void build() {
        InputStream inputStream = Data.class.getResourceAsStream("pcas-code.json");
        StringBuilder json = new StringBuilder();
        FileUtil.convertFileToStringList(inputStream).forEach(json::append);
        try {
            Data.provinces = JsonUtil.getProvincesFromJson(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Province> getProvinces() {
        return provinces;
    }

    public static void setProvinces(List<Province> provinces) {
        Data.provinces = provinces;
    }

}
