package mONDAI;

//クラスNationは、フィールド変数、name（国名）、arer(面積）、population(人口）を持ち
//Nation(String name, int area, int population)のコンストラクタを持ち
//density()メソッド；人口／面積をdouble型で返すメソッドを持ちます
class Nation {
	String name;
	int area;
	int population;

	Nation(String name, int area, int population){
		this.name = name;
		this.area = area;
		this.population = population;
	}
	double density() {
		return (double)population / area;
	}
}
public class M14 {

	public static void main(String[] args) {
		// 人口密度最大の国名と人口密度を表示してください
		Nation[] c = new Nation[3];
		 c[0] = new Nation("USA", 983, 32820);
		 c[1] = new Nation("Rosia" , 1710, 14450);
		 c[2] = new Nation("Japan", 37, 12650);

		 String maxName = c[0].name;
		 double maxDens = c[0].density();
		 for(int i=0;i<c.length;i++) {
			 if(maxDens<c[i].density()) {
				 maxDens=c[i].density();
				 maxName=c[i].name;
			 }
		 }
		 //以下にプログラムを作成



		 System.out.println("国："+ maxName + "   人口密度" + maxDens);


	}

}