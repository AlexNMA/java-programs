import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    System.out.println("File have " + counter(readFile()) + " words.");
  }

  private static String readFile() {
    String data = "";
    try {
      File file = new File("file.txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        data = data + myReader.nextLine();
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return data;
  }

  private static int counter(String string) {
    String words[] = string.split("\\s");
    return words.length;
  }
}
