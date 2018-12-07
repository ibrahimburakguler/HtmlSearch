import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		ArrayList<String> tabu = new ArrayList<String>();

		String word = "";
		boolean ok = true;
		System.out.println("Enter the words in order to check if they exists in web sites then type ok and Enter  :");
		Scanner scan = new Scanner(System.in);
		while (ok) {

			word =scan.next();
			ok = !word.equals("ok");
			if (ok)
				tabu.add(word);
		}

		UrlLibrary urlLibrary = new UrlLibrary();

		for (String html : urlLibrary) {
			System.out.print(urlLibrary.getUrls());

			for (int i = 0; i < tabu.size(); i++) {
				// System.out.print(html.toLowerCase().contains(tabu.get(i)));
				if (html.toLowerCase().contains(tabu.get(i).toLowerCase())) {
					System.out.print(" --> - " + tabu.get(i) + " - is Found.");

				}

			}
			System.out.println();
		}

	}

}
