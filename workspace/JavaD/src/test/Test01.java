package test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test01 {
	public static void main(String[]args) {
		LocalDateTime ldt=LocalDateTime.now();
		OffsetDateTime odt=OffsetDateTime.now();
		ZonedDateTime zdt=ZonedDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/M/d");
		System.out.println(dtf.format(ldt));
		System.out.println(odt);
		System.out.println(zdt);
		int a=17;
		int b=3;
		System.out.println(a/b);

	}
}
