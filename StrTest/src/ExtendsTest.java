class ExtendsTest
{
	public static void main(String[] args) 
	{
		Monitor monitor;
		monitor=new Monitor();
		monitor.stuId="001";
		monitor.name="李明";
		monitor.sex='男';
		monitor.classRoom="信息3班";
		monitor.dept="信息与计算科学";
		monitor.job="班长";
		System.out.println(monitor.stuId+"\n"
		+monitor.name+"\n"+monitor.sex+"\n"
		+monitor.classRoom+"\n"+monitor.dept+"\n"
		+monitor.job+"\n"+monitor.root);
		monitor.show("上学读书");
		monitor.admin("管理班级事物。");
	}
}
class Student
{
	String stuId,name;
	char sex;
	String classRoom;
	String dept;
	final int root=0;
	void show(String s){
		System.out.println(s);
	}
}
class Monitor extends Student
{
	String job;
	final int root=1;
	void admin(String ad){
		System.out.println(ad);
	}
}
