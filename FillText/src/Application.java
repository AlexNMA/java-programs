
public class Application {

  public static void main(String[] args) {
    String string = args[0];
    int n = Integer.parseInt(args[1]);
    fillText(string, n);
  }

  private static void fillText(String text, int n) {
   for(int i = 1; i<=n; i++){
    System.out.println(text);
   }
  }

}
