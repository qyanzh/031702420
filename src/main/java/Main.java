import bean.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data.build();
        try {
            String inputPath = args[0];
            List<String> input = FileUtil.convertFileToStringList(inputPath);
            List<Result> results = new ArrayList<>();
            input.forEach(s -> results.add(new Trimmer(s).trim().toResult()));
            String output = JsonUtil.convertResultsToJson(results);
            String outputPath = args[1];
            FileUtil.convertStringToFile(output,outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
