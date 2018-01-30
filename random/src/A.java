public class A
{
	public void run(){
		System.out.println("A run()");
	}
	public void speak(){
		System.out.println("A speak()");
	}
	public static void say(){
		System.out.println("A say()");
	}
	public A(){
		System.out.println("A构造");
		say();
		speak();
	}
}
class B extends A
{
	public void speak(){
		System.out.println("B speak()");
	}
	public static void say(){
		System.out.println("B say()");
	}
	public B(){
		System.out.println("B构造");
	}
	public static void main(String[] args){
		//B b=new B();
		//b.say();
		//b.run();
		//A a=new B();
		//a=new A();
		//System.out.println(Suber.i);
		//System.out.println(Super.i);
		//Super s=new Super();
		//s=new Suber();
		SuberSun s=new SuberSun();
		System.out.println(s.i);
	}
}
class SuperA{
	static{
		System.out.println("SuperA");
	}
	public static int i=5;
}
class SuberA extends SuperA{
	static{
		System.out.println("Suber");
	}
}
class SuberSun extends SuberA{
	static{
		System.out.println("SuberSun");
	}
}
