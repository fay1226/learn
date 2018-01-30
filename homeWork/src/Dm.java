class Person
{
	private String name;
	private int age;
	public void setName(String n){
		name=n;
	}
	public String getName(){
		return name;
	}	
	public void setAge(int a){
		age=a;
	}
	public int getAge(){
		return age;
	}
	public void say(){
		System.out.println("ta说汉语。");
	}
}
    
class Dm
{
	public static void main(String[] args){
		Person person=new Person();
		person.setAge(23);
		person.setName("青锋");
		System.out.println("person的姓名："+person.getName());
		System.out.println("person的年龄："+person.getAge());
		person.say();
	}
}
