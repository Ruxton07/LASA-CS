import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import  java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    ArrayList<AbstractLocale> locales = getLocales();
    int a = 1;
    Scanner scan = new Scanner(System.in);
    for (AbstractLocale locSelect : locales) {
      System.out.println(a + "" + ". " + locSelect.getLocation() + " (" + locSelect.getLanguage() + ")");
    }
    System.out.println("What locale do you want?");
    int locIndex = scan.nextInt() - 1;
    System.out.println(locales.get(locIndex).getGreeting());
    System.out.println("What's the hour?");
    int hr = scan.nextInt();
    System.out.println("What's the minute?");
    int min = scan.nextInt();
    System.out.println("The local time is: " + locales.get(locIndex).getLocalTime(hr, min));
    System.out.println("How much money do you have in your wallet or purse?");
    double cashAmt = scan.nextDouble();
    System.out.println("In " + locales.get(locIndex).getLocation() + ", that's worth " + locales.get(locIndex).getCurrencySymbol() + locales.get(locIndex).getCurrencyValue(cashAmt) + "!");
  }

  /**
   * DO NOT MODIFY THIS METHOD.
   * Scans the directory of your .java file for all implementations of
   * AbstractLocale, instantiates them, and puts them in an ArrayList.
   * @return the list of locale implementations.
   */
  public static ArrayList<AbstractLocale> getLocales() {
    ArrayList<AbstractLocale> locales = new ArrayList<AbstractLocale>();
    File pwd = new File(
        ClassLoader.getSystemClassLoader().getResource("").getPath());
    File[] classFiles = pwd.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.endsWith(".class");
        }});
    for(File f : classFiles) {
      String className = f.getName().replace(".class", "");
      try {
        Class<?> c = Class.forName(className);
        if (!c.getName().equals("AbstractLocale")) {
          Object obj = c.newInstance();
          if (obj instanceof AbstractLocale)
            locales.add((AbstractLocale)obj);
        }
      } catch (ClassNotFoundException e) {
        System.err.println("Class not found: " + className);
      } catch (InstantiationException e) {
        System.err.println("Error instantiating the object: " + className);
      } catch (IllegalAccessException e) {
        System.err.println("Invalid method access for " + className);
      }
    }
    return locales;
  }
}
