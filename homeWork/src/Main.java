import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Student student=new Student();
		student.setIdName("12141303","范青锋");
		student.setSex('男');
		student.setAge(21);
		student.setBirth("1994-12-26");
		student.setHigh(168.5);
		student.setWeight(105);
		System.out.println(student.getIdName()+"\n性别:"
		+student.getSex()+"\n年龄:"+student.getAge()+"岁\n生日:"
		+student.getBirth()+"\n身高:"+student.getHigh()+"cm\n体重:"
		+student.getWeight()+"斤");
		work("职位:学生。");
	}
	public static void work(String s){
		System.out.println(s);
	}
}
