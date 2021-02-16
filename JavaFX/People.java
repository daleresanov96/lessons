
class Teachers{
	String msg="";
	String name="";
	Teachers(String name,String msg){
		this.name=name;this.msg=msg;}
		public void hello(){
		System.out.println(name+"  "+msg);
	}
}
public class People{
	public static void main(String[] args) {
	Teachers tk=new Teachers("田中", "元気ですか？");
	Teachers yt=new Teachers("山本", "出席たりてますか？");
	Teachers yn=new Teachers("吉野", "ALOHA!");
	tk.hello();
	yt.hello();
	yn.hello();
	Attack(tk,yt);
	}
	public void Attack(Teachers a,Teachers b){
		System.out.println(a.name+"gg");
	}
}