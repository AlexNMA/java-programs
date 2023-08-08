import java.util.ArrayList;

public class Application {
  static ArrayList<Rule> rules = new ArrayList<>();

  public static void main(String[] args) {
    String fileName = "inputRulesAndExpression.txt";
    FileClass file = new FileClass();
    String content = file.readFile(fileName);
    createSetOfRules(content);
    String expression = getExpression(content);

    while (canBeSimplified(expression)) {
      expression = simplifyExpression(expression);
    }
    file.writeFile("outputExpression.txt", expression);
  }

  /*
   * String need "Rules:\n" and rules ended with new line and "Expression:\n"
   * without them searching dosent work
   */
  // Rules work only in one format example ("a b c -> d")
  private static void createSetOfRules(String string) {
    int index = string.indexOf("Rules:") + string.indexOf("\n") + 1,
        indexStop = string.lastIndexOf("Expression:\n"),
        indexOfSeparator = 0,
        indexOfEndLine = 0;
    String ruleString,
        replaceString;

    while (index < indexStop) {
      indexOfSeparator = string.indexOf("->", index) + 2;
      indexOfEndLine = string.indexOf("\n", indexOfSeparator);
      ruleString = string.substring(index, indexOfSeparator - 3);
      replaceString = string.substring(indexOfSeparator + 1, indexOfEndLine);
      index = indexOfEndLine + 1;
      rules.add(new Rule(ruleString, replaceString));
    }
  }

  private static String getExpression(String string) {
    int index = string.indexOf("Expression:") + 12,
        indexOfEndLine = string.length();
    return string.substring(index, indexOfEndLine);
  }

  private static boolean canBeSimplified(String expression) {
    for (Rule r : rules) {
      // if (r.indexOf(expression) != null)
      if (expression.indexOf(r.toFind) != -1) {
        return true;
      }
    }
    return false;
  }

  private static String simplifyExpression(String expression) {
    for (Rule rule : rules) {
      expression = expression.replaceAll(rule.toFind, rule.toReplace);
    }
    return expression;
  }

}
