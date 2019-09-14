import Bean.Province;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class Data {

    private static List<Province> provinces;

    public static void build() {
        InputStream inputStream = Data.class.getResourceAsStream("pcas-code.json");
        StringBuilder json = new StringBuilder();
        FileUtil.convertFileToStringList(inputStream).forEach(json::append);
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Province.class);
        JsonAdapter<List<Province>> adapter = moshi.adapter(type);
        try {
            Data.provinces = adapter.fromJson(json.toString());
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
