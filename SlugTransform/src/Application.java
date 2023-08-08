import java.io.Console;

public class Application {

  public static void main(String[] args) {
    Console console = System.console();
    if (args.length > 0) {
      String string = args[0];
      slugTransform(string);

    } else {
      System.out.println("Type a String");
      slugTransform(console.readLine());

    }
  }

  public static void slugTransform(String string) {
    string = string.toLowerCase();
    string = string.replaceAll("[^a-zA-Z0-9 ]", "");
    string = string.replace(' ', '-');
    System.out.println(string);

  }

}
