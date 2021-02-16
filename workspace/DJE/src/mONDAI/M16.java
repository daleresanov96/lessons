package mONDAI;
//クラスPetは、String型のname（名前）とString型のkinds（種類）を持ちます。
class Pet {
	String name;
	String kinds;
//コンストラクタ
	Pet(String name, String kinds) {
		this.name = name;
		this.kinds = kinds;
	}
}

public class M16 {

	public static void main(String[] args) {
		//3匹のペットのインスタンスを作成します。
		Pet p1 = new Pet("ポチ", "dog");
		Pet p2 = new Pet("ミケ", "cat");
		Pet p3 = new Pet("タロウ", "turtle");
		//  p1のペットの名前を表示してください。
		System.out.println(p1.name);
		 //  p2のペットの種類を表示してください。
		System.out.println(p2.kinds);
		// p3のペットの名前と種類を表示してください
		System.out.println(p3.name+"\t"+p3.kinds);

	}

}
