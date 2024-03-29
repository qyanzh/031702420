package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> convertFileToStringList(String inputPath) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(inputPath);
        return convertFileToStringList(fileInputStream);
    }

    public static List<String> convertFileToStringList(InputStream fileInputStream) {
        List<String> stringList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                stringList.add(tempString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringList;
    }

    public static void convertStringToFile(String target, String path) {
        BufferedWriter writer = null;
        File file = new File(path);
        try {
            if (file.exists()) {
               file.delete();
               file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            writer = new BufferedWriter(outputStreamWriter);
            writer.write(target);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
