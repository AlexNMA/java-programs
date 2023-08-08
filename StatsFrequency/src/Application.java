import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Application {
  public static ArrayList<Word> words = new ArrayList<>();

  public static void main(String[] args) {
    Console console = System.console();
    if (args.length > 0) {
      String string = args[0];
      frequencyWords(string);

    } else {
      System.out.println("String");
      String string = console.readLine();
      frequencyWords(string);
    }
  }

  public static void frequencyWords(String string) {
    string = string.replaceAll("[^a-zA-Z0-9 ]", "");
    string = string.trim().replaceAll(" +", " ");
    counterAllWords(string);
    Collections.sort(words, Comparator.comparing(Word::getCounter).reversed());
    for (Word word : words) {
      System.out.println(word.getWord() + " - " + word.getCounter());
    }
    words.clear();
  }

  public static void counterWord(String stringForOneWord, String word, int size) {
    int counter = 1;
    boolean wordExist = true;
    if (stringForOneWord.indexOf(" ") != -1)
      stringForOneWord = stringForOneWord.substring(stringForOneWord.indexOf(" "));
    while (!stringForOneWord.isEmpty()) {

      if (stringForOneWord.indexOf(word) != -1) {
        counter++;
      } else {
        break;
      }

      stringForOneWord = stringForOneWord.substring(stringForOneWord.indexOf(word) + size);
    }
    if (words.size() == 0) {
      words.add(new Word(word, counter));
    }
    for (Word item : words) {
      if (item.getWord().equals(word)) {
        wordExist = true;
        break;
      }
      wordExist = false;
    }
    if (!wordExist) {
      words.add(new Word(word, counter));
      wordExist = true;
    }
  }

  public static void counterAllWords(String stringForAllWords) {
    int index;
    String word;
    int size;
    while (!stringForAllWords.isEmpty()) {

      if (stringForAllWords.indexOf(" ") == -1) {
        index = stringForAllWords.length();
      } else {
        index = stringForAllWords.indexOf(" ");
      }
      word = stringForAllWords.substring(0, index);
      size = word.length();
      if (!word.equals("") && !word.equals(" ")) {
        counterWord(stringForAllWords, word, size);
      }
      if (stringForAllWords.indexOf(" ") != -1) {
        index++;
      }
      stringForAllWords = stringForAllWords.substring(index);

    }
  }

}
