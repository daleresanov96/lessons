package mONDAI;

class PC{
	String name;
	int perform;
	int price;
	PC(String name, int perform, int price){
		this.name = name; this.perform = perform; this.price = price;
	}
	int cP() {
		int cp = perform / price;
		return cp;
	}
}
public class M18 {

	public static void main(String[] args) {
		PC pc1= new PC("Delo", 10000, 25);
		PC pc2 = new PC("HuwP", 4000, 18);
		PC pc3 = new PC("OMEN", 16000, 40);

		int cpMax = pc1.cP();
		String cpName = pc1.name;
		// 上の３台のPCのなかでコストパフォーマンスが最も良いPCを表示してください
		//　以下にプログラムを作成
		if(cpMax<pc2.cP()) {
			cpMax=pc2.cP();
			cpName=pc2.name;
		}
		if(cpMax<pc3.cP()) {
			cpMax=pc3.cP();
			cpName=pc3.name;




		}
		System.out.println("CP最大は" + cpMax + "の" + cpName + "です");
	}

}
