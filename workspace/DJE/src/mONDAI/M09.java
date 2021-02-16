package mONDAI;

public class M09 {

	public static void main(String[] args) {
		//配列 arr にint型の点数が入っています。
		//　配列の何番目ｉと点数XXを引数として、
		//『i 番目はＸＸ点でした』と表示するメソッドprint()を作成してください。
		//　2つの引数、戻り値なしのメソッドの呼び出しと作成
		int[] arr = {100, 75, 80, 90, 55};
		for(int i = 0; i < arr.length; i++) {
			print(i, arr[i]);
		}
	}
	// ここにメソッドを書く
	public static void print(int i, int point) {
		System.out.println( i +"番目は" + point + "点でした");
	}
}
