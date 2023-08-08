import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    String string;

    Console console = System.console();
    if (args.length > 0) {
      string = args[0];
      searchDate(string);
    } else {
      System.out.println("Enter String:");
      string = console.readLine();
      searchDate(string);

    }
  }

  public static void searchDate(String string) {
    String regex = "\\d{2}(.|/|-)\\d{2}(.|/|-)\\d{4}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(string);
    while(matcher.find()){
      System.out.println(matcher.group());
    }
  
  }
}

 