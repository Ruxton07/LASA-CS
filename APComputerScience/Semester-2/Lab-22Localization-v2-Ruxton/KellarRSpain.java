import java.util.Calendar;
import java.util.TimeZone;

public class KellarRSpain extends AbstractLocale {

  public KellarRSpain() {
    super("Spain", "Spanish");
  }

  public String getGreeting() {
    return "Hola";
  }

  public String getCurrencySymbol() {
    return "€";
  }

  public double getCurrencyValue(double dollarAmount) {
    return dollarAmount*.94;
  }

  public String getLocalTime(int hr, int min) {
    return String.format("%d:%02d", hr+13, min);
  }
}