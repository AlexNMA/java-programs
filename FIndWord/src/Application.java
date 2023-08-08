import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

  static String text = readFile();

  public static void main(String[] args) {
    Console console = System.console();
    System.out.println("Cauta in text: ");
    String foundMe = console.readLine();
    ArrayList<Integer> idexs = findWord(foundMe);
    System.out.println("Locatiile cuvantului " + foundMe + " sunt: ");
    for (Integer integer : idexs) {
      System.out.println(integer);

    }
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
      e.printStackTrace();
    }
    return data;
  }

  private static ArrayList<Integer> findWord(String word) {
    ArrayList<Integer> foundList = new ArrayList<Integer>();
    String tempText = text;
    int i = text.indexOf(word);
    // Not found
    if (i == -1) {
      foundList.add(0);
      return foundList;
    }
    int j = 0;
    while (i > 0) {

      j = j + tempText.indexOf(word);
      foundList.add(j);
      if (i > 1) {
        tempText = tempText.substring(i + 10);
      }
      i = tempText.indexOf(word);
    }

    return foundList;
  }
}
