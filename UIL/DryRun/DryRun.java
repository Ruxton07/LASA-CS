import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DryRun {
	public static void main(String[] args) throws FileNotFoundException {
		String inputFile = "C:\\Users\\rtkel\\Documents\\School\\UIL\\DryRun\\dryrun.dat";
		File file = new File(inputFile);
		Scanner scan = new Scanner(file);
		int n = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < n; i++) {
			String item = scan.nextLine();
			System.out.println("I like " + item + ".");
		}
		scan.close();
	}
}