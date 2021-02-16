package mONDAI;

public class M08 {

	public static void main(String[] args) {
		int[][]  ar1 = new int[][] {{1, 2, 3}, {4, 5, 6}};
		int[][] ar2 = new int[][] {{10, 20, 30}, {40, 50, 60}};
		// ar1 と ar2の各要素の和の配列　ar3を作り、各要素を表示してください
		//　2次元配列の作成、要素の呼び出しの確認
		int[][] ar3 = new int[2][3];
		for(int i = 0;  i < ar1.length; i++) {
			for(int j = 0; j < ar1[0].length; j++) {
				ar3[i][j] = ar1[i][j] + ar2[i][j] ;
				System.out.print("[" + i +"]" +"[" + j +"]" + "="  + ar3[i][j] + " \t");
			}System.out.println();
		}
	}
}
