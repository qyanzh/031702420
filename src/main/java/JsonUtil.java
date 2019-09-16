import Bean.Province;
import Bean.Result;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

class JsonUtil {

    private static Moshi moshi = new Moshi.Builder().build();

    static String convertResultsToJson(List<Result> results) {
        Type type = Types.newParameterizedType(List.class, Result.class);
        JsonAdapter<List<Result>> adapter = moshi.adapter(type);
        return adapter.toJson(results);
    }

    static List<Province> getProvincesFromJson(String json) throws IOException {
        Type type = Types.newParameterizedType(List.class, Province.class);
        JsonAdapter<List<Province>> adapter = moshi.adapter(type);
        return adapter.fromJson(json);
    }
}
