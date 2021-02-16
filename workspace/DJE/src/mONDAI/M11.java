package mONDAI;

public class M11 {

	public static void main(String[] args) {
		// 整数型の配列を引数とし、各要素を二乗するメソッドpow2を使って
		//メインメソッドで、/拡張ｆｏｒ文を使って二乗前と後を並べて表示してください、
		//　出力　　1 3 5 7
		//　　　　　1 9 25 49
		int[]  a= {1,3,5,7};
		//　メインメソッド
//		  以下にプログラムを作成
		for(int num:a) {
			System.out.print(num+" ");
		}
		pow2(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}

	}
	public static void pow2(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = array[i] * array[i];
		}
	}
}
