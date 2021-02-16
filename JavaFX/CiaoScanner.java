import java.util.Scanner;
public class CiaoScanner{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("input your name:       >");
		String name=sc.nextLine();
		System.out.print("input your msg :       >");
		String msg=sc.nextLine();
		for(int i=0;i<10;i++){
			System.out.println(msg+"  from  "+name);
		}
	}
}