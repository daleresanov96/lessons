package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReadSample {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("C:\\Users\\200023\\Desktop\\workspace\\JavaD\\src\\ex01\\test.txt" );
			BufferedReader br = Files.newBufferedReader(path, Charset.forName("MS932"));
			// BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8); //UTF-8は省略可能

			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				System.out.println(++count + "行目:" + line);
			}
			br.close();
			} catch (IOException ex) {ex.printStackTrace();}
	}
}
