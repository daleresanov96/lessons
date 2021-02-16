package mONDAI;

import java.util.Scanner;

public class M05 {
	public static void main(String[] args) {
		//Scannerから文字を入力されたらその内容を表示します。
		// ”Ｅ”or "e"のときbreakでループを抜けて終了するプログラムを作成して下さい
		//　while(true)の無限ループ、breakによる脱出、 ||のor条件　の確認　
		Scanner sc = new Scanner(System.in);
		System.out.print("input(終了はＥ：");

		while(true) {
			String input = sc.nextLine();
			if(input.equals("E") || input.equals("e")) {
				break;
			}System.out.println(input);
		}
	}
}
