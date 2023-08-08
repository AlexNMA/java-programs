import java.io.Console;

public class Application {

  public static void main(String[] args) {
    Console console = System.console();
    if (args.length > 0) {
      String password = args[0];
      checkPassword(password);
    } else {
      System.out.println("Type a password");
      checkPassword(console.readLine());
    }
  }

  public static void checkPassword(String password) {
    boolean lengh = true, uperLetter = true, lowerLetter = true, number = true, specialCharacter = true;
    if (password.length() < 8) {
      System.out.println(ConsoleColors.RED + "The password must contain at least 8 characters." + ConsoleColors.RESET);
      return;
    }
    if (!passwordFiltering(password, 65, 90)) {
      System.out.println(
          ConsoleColors.RED + "The password should contain at least 1 uppercase character." + ConsoleColors.RESET);
      return;
    }
    if (!passwordFiltering(password, 97, 122)) {
      System.out.println(
          ConsoleColors.RED + "The password should contain at least 1 lowercase character" + ConsoleColors.RESET);
      return;
    }
    if (!passwordFiltering(password, 48, 57)) {
      System.out.println(ConsoleColors.RED + "The password must contain at least 1 number." + ConsoleColors.RESET);
      return;
    }
    if (!passwordFiltering(password, 33, 47) &&
        !passwordFiltering(password, 58, 64) &&
        !passwordFiltering(password, 91, 96) &&
        !passwordFiltering(password, 123, 126)) {
      System.out
          .println(ConsoleColors.RED + "The password must contain at least 1 special character." + ConsoleColors.RESET);
      return;
    }
    if (lengh && uperLetter && lowerLetter && number && specialCharacter) {
      System.out.println(ConsoleColors.GREEN + "The password is strong" + ConsoleColors.RESET);
    }
  }

  public static boolean passwordFiltering(String password, int indexStart, int indexEnd) {
    for (int i = 0; i < password.length(); i++) {
      if (password.charAt(i) >= indexStart && password.charAt(i) <= indexEnd) {
        return true;
      }
    }
    return false;
  }

  public class ConsoleColors {
    public static final String RESET = "\033[0m"; // Text Reset
    public static final String RED = "\033[0;31m"; // Text Red
    public static final String GREEN = "\033[0;32m"; // GREEN
  }

}
