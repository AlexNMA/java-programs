
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    String read = readFile("inputString.txt");
    ArrayList<String> arrayList = wordsListArray(read);
    HashMap<String, Integer> hashMap = pairCounters(arrayList);
    String string = stringify(hashMap);
    fileWriter("outputString.txt", string);

  }

  private static String readFile(String fileName) {
    String absPath = System.getProperty("user.dir") + File.separator + fileName;
    String data = "";
    try {
      File file = new File(absPath);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        data += myReader.nextLine();
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return data;
  }

  public static void fileWriter(String fileName, String content) {
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

  public static ArrayList<String> wordsListArray(String fileString) {
    ArrayList<String> results = new ArrayList<>();
    int index = 0;
    fileString = fileString.replaceAll("[^a-zA-Z ]", "");
    do {
      int indexOfSpace = fileString.indexOf(" ", index);
      if (indexOfSpace == -1) {
        indexOfSpace = fileString.length();
      }
      results.add(fileString.substring(index, indexOfSpace));
      index = indexOfSpace + 1;
    } while (index <= fileString.length());
    return results;
  }

  public static HashMap<String, Integer> pairCounters(ArrayList<String> stringList) {
    HashMap<String, Integer> counters = new HashMap<>();
    for (int i = 0, j = 1; stringList.size() > j; i++, j++) {
      int counter = 1;
      String stringA = stringList.get(i);
      String stringB = stringList.get(j);
      String pair = stringA + " " + stringB;
      if (counters.get(pair) != null) {
        counter = counters.get(pair) + 1;
      }
      counters.put(pair, counter);
    }
    return counters;
  }

  public static String stringify(HashMap<String, Integer> hashMap) {
    String str = "";
    for (String key : hashMap.keySet()) {
      String pair = key;
      int counter = hashMap.get(key);
      str += pair + " " + counter + "\n";
      //
    }

    return str;
  }

}
