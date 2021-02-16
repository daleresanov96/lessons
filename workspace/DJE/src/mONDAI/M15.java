package mONDAI;

class Pw{
	int id;
	String pw;
	String charset1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String charset2 = "abcdefghijklmnopqrstuvwxyz";
	String charset3 = "0123456789";
	//コンストラクタを以下に作成してください。
	Pw(int id) {




	}
	void showPw() {
		System.out.println(this.id + " " + pw);
	}
}
public class M15 {

	public static void main(String[] args) {
		//Pｗのインスタンスを２つ作り、showPw()で表示してください。
		Pw pw1 = new Pw(123);
		Pw pw2 = new Pw(124);
		pw1.showPw();
		pw2.showPw();

	}

}
