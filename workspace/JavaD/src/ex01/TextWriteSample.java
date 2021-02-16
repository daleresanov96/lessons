package ex01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TextWriteSample {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("C:\\Users\\200023\\Desktop\\workspace\\JavaD\\src\\ex01\\test.txt");
			BufferedWriter wr = Files.newBufferedWriter(path,Charset.forName("MS932"), StandardOpenOption.APPEND);
			PrintWriter pw = new PrintWriter(wr);
			pw.println("あいうえお");
			pw.println("かきくけこ");
			pw.println("さしすせそ");
			pw.close();
			System.out.println("出力が完了しました。");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		}
}
