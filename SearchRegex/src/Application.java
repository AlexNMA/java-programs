import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    String string;
    String searchString;
    Console console = System.console();
    if (args.length > 0) {
      string = args[0];
      searchString = args[1];
      searchByRegex(string, searchString);
    } else {
      System.out.println("Enter String:");
      string = console.readLine();
      System.out.println("Search:");
      searchString = console.readLine();
      searchByRegex(string, searchString);
    }
  }

  public static void searchByRegex(String string, String searchWord) {
    String regex = "\\b";
    for (int i = 0; i < searchWord.length(); i++) {
      regex += "[" + searchWord.toUpperCase().charAt(i) + searchWord.toLowerCase().charAt(i) + "]";
    }
    regex += "\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(string);
    while (matcher.find()) {
      System.out.println(matcher.group() + " index start: " + matcher.start() + " index end: " + matcher.end());
    }

  }
}
