/*
 * There are two 4-digit numbers that if you raise each of their digits to the
 * 7th power and add them
 * together you get a number that in the octal number representation is equal to
 * the original number.
 * Let’s try this with the number 2123. The sum of all four digits of 2123 each
 * raised to the 7th power is
 * 2
 * 7 + 17 + 27 + 37 = 2444
 * Treating 2444 as an octal number we see that its decimal value is 1316.
 * However, since 1316 is
 * not equal to the original number 2123, this is NOT one of the two numbers we
 * are looking for.
 * Input
 * None.
 * Output
 * Print each of the numbers on a separate line
*/

public class powers {
  public static void main(String[] args) {
    for (int i = 1000; i <= 9999; i++) {
      if (isSpecialNumber(i)) {
        System.out.println(i);
      }
    }
  }

  private static boolean isSpecialNumber(int number) {
    int sum = 0;
    int temp = number;

    while (temp > 0) {
      int digit = temp % 10;
      sum += Math.pow(digit, 7);
      temp /= 10;
    }

    return octalToInt(sum) == number;
  }

  private static int octalToInt(int octal) {
    int sum = 0;
    int temp = octal;
    int loop = 0;
    while (temp > 0) {
      int digit = temp % 10;
      sum += digit * Math.pow(8, loop);
      temp /= 10;
      loop++;
    }
    return sum;
  }
}