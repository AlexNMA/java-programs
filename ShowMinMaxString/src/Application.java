
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

  static String text = readFile();

  public static void main(String[] args) {

    Console console = System.console();
    int start;
    int end;
    System.out.println("Alege linia de pornire:");
    start = Integer.parseInt(console.readLine());
    System.out.println("Alege linia de final:");
    end = Integer.parseInt(console.readLine());
    System.out.println(cutFromText(start, end));

  }

  private static String readFile() {
    String data = "";
    try {
      File file = new File("file.txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        data = data + myReader.nextLine() + "\n";
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return data;
  }

  private static String cutFromText(int start, int end) {
    boolean stop = false;
    String tempText = text;
    int i = 1;
    int indexString = 0;
    int indexStart = 0;
    int indexStop = 0;
    int indexOf = tempText.indexOf("\n");
    if (indexOf > 0) {
      while (indexOf > 0) {
        indexString += indexOf;
        if (i == start - 1) {
          indexStart = indexString;
        }
        if (i == end) {
          indexStop = indexString;
          stop = true;
        }
        tempText = tempText.substring(indexOf + 1);
        indexOf = tempText.indexOf("\n");
        if (stop) {
          break;
        }
        i++;
      }
      return text.substring(indexStart + start - 1, indexStop + end - 1);
    }
    return null;
  }
}
