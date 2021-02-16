package mONDAI;

public class M01 {
	public static void main(String[] args) {
		// Random.nextIntを使って整数rndに0，1，2の値をセットします
		//　0だったら『晴れ』、１だったら『曇り』、2だったら『雨』と表示してください。
		// Randomとif- else if- elseの確認
		// 以下ににプログラムを書いてください
		int r=new java.util.Random().nextInt(3);
		String[]str=new String[] {"晴れ","曇り","雨"};
		System.out.println("今の Randomは"+"\t"+r);
		if(r==0) {
			System.out.println(str[0]);
			}else if(r==1){
				System.out.println(str[1]);
		}else {
			System.out.println(str[2]);
		}
	}
}
