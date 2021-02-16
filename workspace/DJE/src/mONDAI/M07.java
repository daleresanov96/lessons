package mONDAI;

public class M07 {

	public static void main(String[] args) {
	//　877円を最も少ない硬貨で支払うと何枚ですか？
	//　硬貨金額配列の初期化、硬貨を高いものから変えながら、金額がプラスの間
	//　枚数を増やしてゆき、その分残高から硬貨金額分へらしてゆく
		int[] coin = new int[] {500, 100, 50, 10, 5, 1};
		int count = 0;
		int rest = 877;
		for(int i = 0; i < coin.length; i++) {
			while(rest >= 0) {
				if (rest - coin[i]  >= 0 ) {
					count ++;
					rest -= coin[i];
				} else {
					break;
				}
			}
		}
		System.out.println(count);
	}
}
