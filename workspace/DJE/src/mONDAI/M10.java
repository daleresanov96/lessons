package mONDAI;

import java.util.Scanner;

public class M10 {

	public static void main(String[] args) {
		// 何月かの数字を渡すと、January, February,...,Decemberと英語を返すメソッドgetMonth(int inp)が
		//あります。これをメインメソッドから呼び出して英語の月の名前を表示してください。
		Scanner sc = new Scanner(System.in) ;
		System.out.print("何月を表示；");
		int inp = sc.nextInt();
		//　以下にメソッドを呼び出すプログラムを作成してください


	}
	public static String getMonth(int inp) {
		String[] months= {"January"," February", "March"," April",
				"May", "June", "July", "August", "Septembef",
				"Octorber", "November", "December"};
		return months[inp - 1];
	}

}
