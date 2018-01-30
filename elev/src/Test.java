import java.util.*;

public class Test
{
	public static void main(String[] args)
	{
		People p1 = new People("A",7,3);
		People p2 = new People("B",6,10);
		People p3 = new People("C",7,8);
		People p4 = new People("D",10,-1);
		//People p5 = new People("E",-1,1);
		Elev elev = new Elev(4,true,true);
		LinkedList<People> list = new LinkedList<People>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		//list.add(p5);
		System.out.println(list);
		System.out.println(elev);
		new Method().runElev(list,elev);
	}
}
