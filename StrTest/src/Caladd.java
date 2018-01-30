import java.util.*;
import java.math.*;
/*
  编程求m~n之和,m<n为任意正整数。
  要求:代码简洁，不使用循环。
*/
public class Caladd
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("请分别输入一个较小的和一个较大的整数：");
			int sub=sc.nextInt(),sup=sc.nextInt();
			System.out.println((sub>sup?sup:sub)+"+"+((sub>sup?sup:sub)+1)+
			"+…+"+(sub>sup?sub:sup)+"="+sum((sub>sup?sup:sub),(sub>sup?sub:sup)));
		}
	}
	public static int sum(int sub,int sup){
		if(sub==sup) return sup;
		return sub+sum(++sub,sup);//递归
	}
}
