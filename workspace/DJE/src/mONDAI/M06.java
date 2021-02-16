package mONDAI;

public class M06 {

	public static void main(String[] args) {
		// 日本の紙幣（しへい）は４種類の金額（きんがく）があります
		//各種１枚ずつ持っているとき、合計金額を計算するプログラムを作成してください。
		//　配列の作成、値の設定、配列の要素をfor文で使う　の確認
		int[] array = new int[4];
		array[0] = 1000;
		array[1] = 2000;
		array[2] = 5000;
		array[3] = 10000;
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("合計は" + sum + "円です");
	}

}
