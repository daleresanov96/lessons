import java.util.Scanner;

public class ScannerTest{
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("input msg");
		String msg=sc.nextLine();
		System.out.println(msg);
	}
}