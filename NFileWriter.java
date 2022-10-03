import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class NFileWriter {
    public static boolean setTextInFile(File file, String data) {
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(data);
            fileWriter.close();
            return true;
        }catch (IOException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
           return false;
       }
    }
}
