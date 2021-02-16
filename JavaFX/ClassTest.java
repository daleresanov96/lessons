class Jon{
	private String msg;
	public void Hello(){
		msg="Hello";
		System.out.println(msg);
	}
}
public class ClassTest{
	public static void main(String[] args) {
		Jon j=new Jon();
		j.Hello();

	}
}