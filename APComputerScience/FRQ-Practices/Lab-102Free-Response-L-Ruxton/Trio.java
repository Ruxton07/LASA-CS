// Complete the Trio class per instructions
public class Trio implements MenuItem {
  private Sandwich sand;
  private Salad bowl;
  private Drink slurp;
  public Trio(Sandwich realSand, Salad realBowl, Drink realDrink) {
    sand = realSand;
    bowl = realBowl;
    slurp = realDrink;
  }
  public String getName() {
    return ""+sand.getName()+"/"+bowl.getName()+"/"+slurp.getName()+" Trio";
  }
  public double getPrice() {
    double total = 0.0;
    for(int i = 0; i < 2; i++) {
      if ((sand.getPrice() >= bowl.getPrice() || sand.getPrice() >= slurp.getPrice()) && total != sand.getPrice())
        total += sand.getPrice();
      else if ((bowl.getPrice() >= sand.getPrice() || bowl.getPrice() >= slurp.getPrice()) && total != bowl.getPrice())
        total += bowl.getPrice();
      else
        if (total != slurp.getPrice())
          total += slurp.getPrice();
    }
    return total;
  }
}