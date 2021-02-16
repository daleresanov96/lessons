import java.util.Scanner;
public class ArrayTest03{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String password01="Jon231123";
		System.out.println("input password");
		String password=sc.nextLine();
		while(true){
		if(password01.equals(password)){
			System.out.println("ok");
		}else{
			System.out.println("invalid");
		}
	}
}