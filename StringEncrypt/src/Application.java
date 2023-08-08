import java.io.Console;
import java.lang.reflect.Array;

public class Application {

  public static void main(String[] args) {
    Console console = System.console();
    if (args.length > 0) {
      String string = args[0];
      int key = Integer.parseInt(args[1]);
      CaesarCipher(string, key);
    } else {
      System.out.println("String");
      String string = console.readLine();
      System.out.println("Key");
      int key = Integer.parseInt(console.readLine());
      CaesarCipher(string, key);
    }
  }

  public static void CaesarCipher(String string, int key) {
    char[] chars = string.toCharArray();
    for (int i = 0; i < string.length(); i++) {
      Array.setChar(chars, i, (char) (string.charAt(i) + key));// chars[i] = (char) (string.charAt(i) + key);
    }
    System.out.println(String.valueOf(chars));

  }

}
