ds// name:  
// purpose: demonstrate further method prowess

public class Invoke 
{
   // method piggyBank(): returns what the change is worth in cents
  public static int piggyBank(int p, int n, int d, int q, int hD) {
    int totCents = 0;
    totCents += p + (n * 5) + (d * 10) + (q * 25) + (hD * 50);
    return totCents;
  }
	

	 // method mp3Sizer(): estimates the number of gB needed to store media
	public static int mp3Sizer(int songs, int vids, int photos) {
    double totSize = 0.0;
    totSize += (songs * 3.04) + (vids * 89.3) + (photos * 1.72);
    totSize /= 1000;
    totSize = Math.ceil(totSize);
    return (int) totSize;
  }
}