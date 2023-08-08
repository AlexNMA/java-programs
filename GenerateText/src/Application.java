import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
  public static ArrayList<WordsProbability> list = new ArrayList<>();

  public static void main(String[] args) {
    Console console = System.console();
    if (args.length > 0) {
      int n = Integer.parseInt(args[0]);
      System.out.println(markovGenerator(n));
    } else {
      System.out.println("Enter a number:");
      int n = Integer.parseInt(console.readLine());
      System.out.println(markovGenerator(n));
    }
  }

  public static void listLoader() {
    String filename = "GenerateTextFile.txt";
    String workingDirectory = System.getProperty("user.dir");
    String absoluteFilePath = workingDirectory + File.separator + filename;
    String data;
    try {
      File file = new File(absoluteFilePath);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        data = myReader.nextLine();
        String firstWord = data.substring(0, data.indexOf(" "));
        data = data.substring(data.indexOf(" ") + 1);
        String nextWord = data.substring(0, data.indexOf(" "));
        data = data.substring(data.indexOf(" ") + 1);
        int probability = Integer.parseInt(data);
        list.add(new WordsProbability(firstWord, nextWord, probability));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static String select(String word) {
    String[] words = new String[10];
    int[] probs = new int[10];
    int i = 0;
    int valueMax = 0;
    int randomizeProbability;
    for (WordsProbability iterable : list) {
      if (iterable.getFirstWord().equals(word)) {
        words[i] = iterable.getNextWord();
        probs[i] = iterable.getProbability();
        i++;
      }
    }
    if (i == 1) {
      return words[0];
    }
    for (int j : probs) {
      valueMax += j;
    }
    randomizeProbability = (int) (Math.random() * (valueMax - 1) + 1);
    for (int j = 0, size = 0; j < i; j++) {

      if (randomizeProbability >= size && randomizeProbability <= probs[j] + size) {
        return words[j];
      }
      size = probs[j];
    }

    return "";
  }

  public static String markovGenerator(int n) {
    listLoader();
    String wordRandomize = list.get((int) (Math.random() * (list.size() - 1) + 1)).getFirstWord();
    String selectedWord = select(wordRandomize);
    String string = selectedWord + " ";
    String lastWord = selectedWord;
    while (n - 1 != 0) {

      selectedWord = select(selectedWord);

      while (selectedWord.equals(lastWord) || selectedWord.equals("")) {
        selectedWord = select(lastWord);
        if (selectedWord.equals("")) {
          wordRandomize = list.get((int) (Math.random() * (list.size() - 1) + 1)).getFirstWord();
          selectedWord = select(wordRandomize);
        }
      }
      string += selectedWord + " ";
      lastWord = selectedWord;
      n--;
    }
    return string;
  }

}
