public class Test01{
	
	public static void main(String[] args) {
		String [] date = getData();
		showDate(date);
		
	}
	public static String[] getData(){
		String [] dt = {"Kristina","Angella","Jenica"};
		return dt;
	}
	public static void showDate(String [] str){
		for(int i=0;i<3;i++){
			System.out.println("                                     "+str[i]);
		}
	}
}