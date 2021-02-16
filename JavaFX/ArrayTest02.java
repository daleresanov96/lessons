import java.util.Scanner;
public class ArrayTest02{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] names=new String[3];
		for (int i=0;i<3;i++) {
			System.out.println("input name"+(i+1)+"    "+">");
			names[i]=sc.next();
		}
		for (int i=0;i<3;i++) {
			System.out.println("name"+(i+1)+"     >"+names[i]);
		}


	}
}