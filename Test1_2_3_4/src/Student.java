public class Student
{
	private String sno;
	private String name;
	private int math;
	private int english;
	private int computer;
	
	Student(String sno,String name,int math,int english,int computer){
		this.sno=sno;
		this.name=name;
		this.math=math;
		this.english=english;
		this.computer=computer;
	}
	public String getSno(){
		return sno;
	}
	public String getName(){
		return name;
	}
	public int sum(){
		return math+english+computer;
	}
	public float avg(){
		return sum()/3;
	}
	public int min(){
		return Math.min(Math.min(math,english),computer);
	}
	public int max(){
		return Math.max(Math.max(math,english),computer);
	}
	public static void main(String[] args){
		Student student=new Student("12141303","范青锋",98,89,99);
		System.out.println("学号："+student.getSno());
		System.out.println("姓名："+student.getName());
		System.out.println("总分："+student.sum());
		System.out.println("平均成绩："+student.avg());
		System.out.println("最低分："+student.min());
		System.out.println("最高分："+student.max());
	}
}
