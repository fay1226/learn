import java.util.*;

public class TransTest
{
	public static void main(String[] args)
	{
		Transport trans=new Transport();
		trans.show();
		trans=new Car();
		trans.show();
		trans.way("汽车走公路。");
		trans=new Van();
		trans.show();
		trans=new Railway();
		trans.show();
		trans.way("火车走铁路。");
	}
}

class Transport
{
	void show(){
		System.out.println("交通工具都可以帮助人类更高效的办事。");
	}
	void way(String road){
		System.out.println(road);
	}
}

class Car extends Transport
{
	void show(){
		System.out.println("汽车有客车和货车。");
	}
	void way(String road)
	{
		super.way(road);
	}
}
class Van extends Car
{
	void show()
	{
		System.out.println("货车一般用来载物。");
	}
}
class Railway extends Transport
{
	void show()
	{
		System.out.println("火车一次能载好多人和物。");
	}
	void way(String road)
	{
		System.out.println(road);
	}
}
