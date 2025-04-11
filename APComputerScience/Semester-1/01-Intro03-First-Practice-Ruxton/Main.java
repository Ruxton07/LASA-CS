class Main {
  final static int DAYS_PER_WEEK = 7;
    public static void main (String[] args) {
      //#1
      int x;
      x=27;
      System.out.println("x = " + x);
      //#2
      x++;
      //#3
      System.out.println("x = " + (x+1));
      //#4
      System.out.println("x = " + x);
      //#5
      x=2147483647;
      System.out.println("x = " + x);
      x++;
      System.out.println("x = " + (x+1));
      System.out.println("x = " + x);
      //#6
      System.out.println("x = " + Integer.MAX_VALUE);
      System.out.println("x = " + Integer.MIN_VALUE);
      //#7
      double y = 6.2;
      System.out.println("y = " + y);
      //#8
      y = 27;
      System.out.println("y = " + y);
      //#9
      char a = '$';
      System.out.println("a = " + a);
      //#10
      a = '\'';
      System.out.println("a = " + a);
      //#11
      String b = "Hello";
      String c = "World";
      System.out.print(b + "\n\\\n" + c + "\n");
      //#12
      int days = 212;
      double daysinweeks;
      daysinweeks = (double) days/ (double) DAYS_PER_WEEK;
      daysinweeks += 0.00000005;
      daysinweeks = (int) (daysinweeks * 10000000);
      daysinweeks = (double) (daysinweeks / 10000000);
      System.out.println(days + " days is " + daysinweeks + " weeks.");
      //#13
      int e = 6;
      int f = 27;
      System.out.println("" + e + " + " + f + " = " + (e+f) + " (not " +  e + f + ")");
      //#14
      double g;
      g = (5.8*2);
      double h = 2.5;
      System.out.println("integer part of g / h = " + (int) (g/h));
    }
  
}
