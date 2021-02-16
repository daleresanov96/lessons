package mONDAI;

public class M04 {

	public static void main(String[] args) {
		// 1から20の数値を順に表示してゆきますが、3の倍数のときだけ
		//表示しないプログラムを作成してください。
		//for文とif文の組み合わせ｛｝のペアを確認、%のあまり、！=の等しくない　の確認
		for(int i = 1; i <= 20; i++) {
			if(i % 3 != 0 ){
				System.out.print(i+"\t");
			}
		}
	}
}
