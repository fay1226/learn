import java.util.*;

public class AB
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("输入一个数a=");
		int a=sc.nextInt();
		System.out.print("输入一个数b=");
		int b=sc.nextInt();
		System.out.println("初始时:\na="+a+",b="+b);
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("交换后:\na="+a+",b="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("再次交换后:\na="+a+",b="+b);
	}
}
