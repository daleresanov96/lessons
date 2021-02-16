package mONDAI;
class HealthData {
private String name;
private double height;
private double weight;
HealthData(String name){
	this.name = name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getweight() {
	return weight;
}
public void setweight(double weight) {
	this.weight = weight;
}
public double getheightt() {
	return height;
}
public void setheight(double height) {
	this.height = height;
}


//　以下に、heightとweightのgetter／setterを記述してください。

            //　②

public void printData() {
	System.out.println("name = " + this.name + "  height = "+ this.height + "  weight ="  + this.weight);
}
}
public class M17 {
public static void main(String[] args) {
//　HealthData型のインスタンスhData1をnameを"たろう"で作成してください。
           //　①
	HealthData hData1=new HealthData("Tarou");
//   hData1のheightに1.80とweightに75.0の値をセットしてください。
           //　③               
	hData1.setweight(75.0);hData1.setheight(1.80);
//　メソッドprintDataを使ってhData1を表示してください
           //　④
	hData1.printData();
}
}