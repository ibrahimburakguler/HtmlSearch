import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class UrlLibrary implements Iterable<String> {
	int i = -1;
	private LinkedList<String> urls = new LinkedList<String>();

	public String getUrls() {

		i++;
		return urls.get(i);

	}

	private class UrlIterator implements Iterator<String> {

		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < urls.size();
		}

		@Override
		public String next() {

			StringBuilder sb = new StringBuilder();

			try {
				URL url = new URL(urls.get(index));

				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

				String line = null;

				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("n");

				}

				br.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("something wrong with the addres");
			}

			index++;

			return sb.toString();
		}

		@Override
		public void remove() {
			urls.remove(index);
		}

	}

	public UrlLibrary() {
		String url = "";
		boolean ok = true;
		System.out.println("Enter the web sites then type ok and Enter  :");
		Scanner scan = new Scanner(System.in);
		while (ok) {

			url = scan.nextLine();
			ok = !url.equals("ok");
			if (ok)
				urls.add(url);
		}

	}

	@Override
	public Iterator<String> iterator() {
		return new UrlIterator();
	}

}