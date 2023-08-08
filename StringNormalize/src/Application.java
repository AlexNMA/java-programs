import java.io.Console;

public class Application {

  public static void main(String[] args) {
    String string = "";
    Console console = System.console();
    System.out.println("Enter string for normalize, for stop press enter button");
    while (true) {
      String tmp = console.readLine();
      if (tmp.isBlank()) {
        break;
      }
      string += tmp + "\n";
    }
    if (!normalizeString(string).equals("StringErrorNull")) {
      System.out.println(normalizeString(string));
    }
  }

  public static String normalizeString(String string) {
    // check if we have at least 2 lines
    if (string.indexOf("\n") == -1) {
      System.out.println("YOU NEED AT LEAST TWO LINES FOR NORMALIZATION");
      return "StringErrorNull";
    }
    String tempString = "";
    int counter = counter(string);
    int seccondCounter = counter;
    // first line string normalize spaces
    tempString += string.substring(counter, string.indexOf("\n") + 1);
    string = string.substring(string.indexOf("\n") + 1);
    // from seccond line to n line normalize spaces
    while (!string.isEmpty()) {
      if (string.indexOf("\n") != -1) {
        if (string.charAt(counter) != ' ') {
          counter = counter(string);
        }
        tempString += string.substring(counter, string.indexOf("\n") + 1);
        string = string.substring(string.indexOf("\n") + 1);
        counter = seccondCounter;
      } else if (string.indexOf("\n") == -1) {
        if (string.charAt(counter) != ' ') {
          counter = counter(string);
        }
        tempString += string.substring(counter, string.length());
        string = string.substring(string.length());
        counter = seccondCounter;
      }
    }
    return tempString;
  }

  // counter spcaes for normalize
  public static int counter(String string) {
    int counter = 0;
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == ' ') {
        counter++;
      }
      if (string.charAt(i) != ' ') {
        break;
      }
    }

    return counter;
  }
}
