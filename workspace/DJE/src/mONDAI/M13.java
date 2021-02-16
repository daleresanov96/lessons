package mONDAI;
//フィールド変数　整数型のｘとｙ 2つをもつクラスを定義して
//矢印（↑↓→←）で座標を移動するmove()メソッドを定義、現在位置を表示する
//現在位置を表示するshowPos()も定義してください。

class Position{
	int x;
	int y;
	//  以下にmoveメソッドとshowPosメソッドを作成してください
	void move(String arrow) {
		if (arrow.equals("↑")) {
			y+=1;
		}else if(arrow.equals("→")) {
			x+=1;
		}else if(arrow.equals("↓")) {
			y-=1;
		}else if(arrow.equals("←")) {
			x-=1;
		}
	}
	void showPos() {
		System.out.println("x= "+x+" y= "+y);
	}

}
public class M13 {

	public static void main(String[] args) {
		// ”↑→→↓↓↓←→”に移動させたときの位置をあたえます。Position型ｐのインスタンスを生成し
		//  最後の位置をshowPos()で表示してください。
		String direct = "↑→→↓↓↓←→";
		Position p = new Position();
		p.x = 0;
		p.y = 0;
		for(int i = 0; i < direct.length(); i++) {
			System.out.println(String.valueOf(direct.charAt(i)));
			p.move(String.valueOf(direct.charAt(i)));
		}
		p.showPos();

	}

}
