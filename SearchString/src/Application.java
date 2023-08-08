import java.io.Console;

public class Application {

  public static void main(String[] args) {
    Console console = System.console();
    if (args.length > 0) {
      String string1 = args[0];
      String string2 = args[1];
      longestCommonSubstring(string1, string2);

    } else {
      System.out.println("String 1:");
      String string1 = console.readLine();
      System.out.println("String 2:");
      String string2 = console.readLine();
      longestCommonSubstring(string1, string2);
    }
  }

  public static void longestCommonSubstring(String string1, String string2) {
    int n = string1.length();
    int m = string2.length();
    int max = 0;

    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (string1.charAt(i) == string2.charAt(j)) {
          dp[i + 1][j + 1] = 1 + dp[i][j];
        } else {
          dp[i + 1][j + 1] = 0;
        }

      }
    }
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (max < dp[i][j]) {
          max = dp[i][j];
        }
      }
    }
    System.out.println("The longest common substring is " + max);
  }

}
