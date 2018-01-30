import java.util.*;

public class CampShort
{
	public static void main(String[] args){
		Student1 stu=new Student1();
		stu.setId(1);
		stu.setName("fqf");
		ArrayList<Student1> li=new ArrayList<Student1>();
		li.add(stu);
		li.add(new Student1(2,"jw"));
		Iterator<Student1> it=li.iterator();
		while(it.hasNext()){
			stu=new Student1();
			stu=it.next();
			System.out.println(stu.getId()+stu.getName());
		}
	}
}

class Student1
{
	private int id;
	private String name;

	public Student1(){}
	public Student1(int id,String name){
		this.id=id;
		this.name=name;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return id;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
