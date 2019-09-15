import Bean.Result;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data.build();
        String inputPath = args[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(inputPath);
            List<String> input = FileUtil.convertFileToStringList(fileInputStream);
            List<Result> results = new ArrayList<>();
            input.forEach(s -> results.add(new Trimmer(s).trim().toResult()));
            String output = resultToJson(results);
            String outputPath = args[1];
            FileUtil.stringToFile(output,outputPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String resultToJson(List<Result> results) {
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Result.class);
        JsonAdapter<List<Result>> adapter = moshi.adapter(type);
        return adapter.toJson(results);
    }

}
