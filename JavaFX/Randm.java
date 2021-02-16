import java.util.Random;
import java.util.Scanner;
public class Randm{
	public static void main(String[] args) {
		Random rm=new Random();
		Scanner sc=new Scanner(System.in);
		int r=0;
		while(true){		
			r++;
			int t=rm.nextInt(10);
			System.out.println("your answer? >");
			int a=sc.nextInt();
			if (a==t) {
				System.out.println("You win!"+"    <"+r+">");
				break;
			}else{
				System.out.println("target : "+t+"     <"+r+">");
				
			}
		}
	}
}