import java.util.Random;
public class Fortune{
	public static void main(String[] args) {
		Random rn=new Random();
		for(int i=0;i<10;i++){
		int num=rn.nextInt(3);
		System.out.println(num);
		}
	}
}