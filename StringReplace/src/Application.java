import java.io.Console;

public class Application {

  public static void main(String[] args) {
    String string;
    String word;
    String subString;
    Console console = System.console();
    if (args.length > 0) {
      string = args[0];
      word = args[1];
      subString = args[2];
      System.out.println(replaceAllSubstring(string, word, subString));
    } else {
      System.out.println("Enter String:");
      string = console.readLine();
      System.out.println("Enter word");
      word = console.readLine();
      System.out.println("Enter replace word");
      subString = console.readLine();
      System.out.println(replaceAllSubstring(string, word, subString));
    }
  }

  public static String replaceAllSubstring(String string, String word, String subString) {
    String regex = "\\b" + "[" +
        word.toUpperCase().charAt(0) +
        word.toLowerCase().charAt(0) +
        "]" + word.substring(1) +
        "\\b";
    return string.replaceAll(regex, subString);
  }
}
