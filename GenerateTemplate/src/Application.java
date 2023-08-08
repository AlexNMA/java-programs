import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    String variableString;
    String replaceVariables;
    Console console = System.console();
    if (args.length > 0) {
      variableString = args[0];
      replaceVariables = args[1];
      generateTemplate(variableString, replaceVariables);
    } else {
      System.out.println("Enter variable:");
      variableString = console.readLine();
      System.out.println("Replacement variable:");
      replaceVariables = console.readLine();
      generateTemplate(variableString, replaceVariables);
    }
  }

  public static void generateTemplate(String variableString, String replaceVariable) {
    String data = "";
    String regex = "\\b" + variableString + "\\b";
    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    String absPath = System.getProperty("user.dir") + File.separator + "variablesFile.txt";

    try {
      File file = new File(absPath);
      Scanner myReader = new Scanner(file);

      while (myReader.hasNextLine()) {
        data += myReader.nextLine() + "\n";
      }

      myReader.close();
      Matcher matcher = pattern.matcher(data);
      if (matcher.find()) {
        data = data.replaceAll(regex, replaceVariable);
        fileWriter(data);
      } else {
        System.out.println("The variable \"" + variableString + "\"" + " does not exist in the file");
        return;
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  public static String generateNewFileName() {
    return generateNewFileName(false);
  }

  public static String generateNewFileName(Boolean delete) {

    String fileName = "";
    String workingDirectory = System.getProperty("user.dir") + File.separator;
    File[] files = new File(workingDirectory).listFiles();
    for (File file : files) {
      if (file.isFile()) {
        if (!file.getName().equals("README") && !file.getName().equals("variablesFile.txt")) {
          fileName = file.getName();
        }
      }
    }
    if (fileName.length() >= 0 && fileName.length() < 10) {
      fileName = "variablesFile01.txt";
    } else {
      String regex = "\\d{2}";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(fileName);
      while (matcher.find()) {
        int digit;
        if (delete == true) {
          digit = Integer.parseInt(matcher.group()) - 2;
        } else {
          digit = Integer.parseInt(matcher.group());
        }
        if (digit < 9) {
          fileName = "variablesFile0" + (digit + 1) + ".txt";
        } else {
          fileName = "variablesFile" + (digit + 1) + ".txt";
        }
      }
    }
    return workingDirectory + fileName;
  }

  public static void fileWriter(String string) {
    try {
      File file = new File(generateNewFileName());
      file.createNewFile();
      FileWriter writer = new FileWriter(file);
      writer.write(string);
      writer.close();
      File deleteOldFile = new File(generateNewFileName(true));
      if (deleteOldFile.exists()) {
        deleteOldFile.delete();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
