import java.io.Console;

public class Application {

  public static void main(String[] args) {
    Console console = System.console();
    if (args.length > 0) {
      String string = args[0];
      CamelTransform(string);

    } else {
      System.out.println("Type a String");
      CamelTransform(console.readLine());

    }
  }

  public static void CamelTransform(String string) {
    char[] chars = string.toCharArray();
    chars[0] = string.toUpperCase().charAt(0);
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ' ') {
        chars[i] = '\u0000';
        chars[i + 1] = string.toUpperCase().charAt(i + 1);
        i++;
      }
    }

    System.out.println(String.valueOf(chars));

  }

}
