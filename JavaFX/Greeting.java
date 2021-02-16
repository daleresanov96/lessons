import java.util.Scanner;
public class Greeting{
	public static void main(String[] args) {
		String msg =getGreeting();
		System.out.println(msg);
	}
	public static String getGreeting(){
		Scanner sc=new Scanner(System.in);
		System.out.print("input name>");
		String msg =sc.nextLine();
		return msg;
	}
}