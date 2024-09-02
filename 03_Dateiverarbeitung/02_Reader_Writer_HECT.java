package muell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Anwendung {

	public static void main(String[] args) {
		Path path = Paths.get("test.txt");

		//ohneBuffer(path);
		mitBuffer(path);
		leseEin(path);

	}

	private static void leseEin(Path path) {
		try {
			Path path2 = Paths.get("test2.txt");
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			BufferedWriter writer = Files.newBufferedWriter(path2, Charset.forName("UTF-8"));
			String line = reader.readLine();
			while(line != null) {
				if(line.startsWith("-")) {
					writer.write(line.substring(1)+"\n");
				}else {
					writer.write(line+"\n");
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void ohneBuffer(Path path) {
		System.out.println("Start 1");
		Random r = new Random();
		int i = 0;
		while (i < 100000) {
			String question = Integer.toString(r.nextInt(10));
			try {
				Files.write(path, question.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		}
		System.out.println("Ende 1");
	}

	public static void mitBuffer(Path path) {

		Random r = new Random();
		System.out.println("Start 2");
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
			for (int i = 0; i < 100000; i++) {
				writer.write(Integer.toString(r.nextInt()) + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ende 2");

	}

}
