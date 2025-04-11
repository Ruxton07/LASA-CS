class Alice {
  public static void main(String[] args) {
    String sailboat = "";
    for (int i = 0; i < 3; i++) {
      sailboat += "&";
      System.out.println("          " + sailboat);
    }
    sailboat = "";
    for (int i = 0; i < 4; i++) {
      sailboat += "-";
      System.out.println("          &&" + sailboat + "&");
    }
    sailboat = "";
    for (int i = 0; i < 13; i++) {
      sailboat += ".";
      System.out.println("          &&--" + sailboat + "--&");
    }
    System.out.println("           ||                   \\o/");
    System.out.println("           ||                    |");
    System.out.println(" ======================================");
    System.out.println("   ==================================");
    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
  }
}