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


//�@�ȉ��ɁAheight��weight��getter�^setter���L�q���Ă��������B

            //�@�A

public void printData() {
	System.out.println("name = " + this.name + "  height = "+ this.height + "  weight ="  + this.weight);
}
}
public class M17 {
public static void main(String[] args) {
//�@HealthData�^�̃C���X�^���XhData1��name��"���낤"�ō쐬���Ă��������B
           //�@�@
	HealthData hData1=new HealthData("Tarou");
//   hData1��height��1.80��weight��75.0�̒l���Z�b�g���Ă��������B
           //�@�B               
	hData1.setweight(75.0);hData1.setheight(1.80);
//�@���\�b�hprintData���g����hData1��\�����Ă�������
           //�@�C
	hData1.printData();
}
}