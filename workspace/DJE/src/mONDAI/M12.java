package mONDAI;
//クラスOurClassが、
//フィールド変数　String name（クラス名）, int num(人数）
//メソッド　showClass()　クラス名：IG12　　　人数：24名と表示します
//の２つを持つように、定義してください
class OurClass {
	String name;
	int num;

	void showClass(){
		System.out.println("クラス名：" + name + "    人数：" + num);
	}
}
public class M12 {
//IG12  24　と　IG11　44　の2つのOurClass型のインスタンスを生成し
//値をセットして、各々表示(showClassを呼び出し）してください。
	public static void main(String[] args) {
		OurClass c1 = new OurClass();
		c1.name = "IG12";
		c1.num =  24;
	    OurClass c2 = new OurClass();
	    c2.name = "IG11";
	    c2.num = 43;

	    c1.showClass();
	    c2.showClass();
	    }

	}


