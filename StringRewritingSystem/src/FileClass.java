import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileClass {

    public String readFile(String fileName) {
        String absPath = System.getProperty("user.dir") + File.separator + fileName;
        String stringContent = "";
        try {
            File file = new File(absPath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                stringContent += myReader.nextLine() + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringContent;
    }

    public void writeFile(String fileName, String content) {
        String absPath = System.getProperty("user.dir") + File.separator + fileName;
        try {
            File deleteOldFile = new File(absPath);
            if (deleteOldFile.exists()) {
                deleteOldFile.delete();
            }
            File file = new File(absPath);
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
