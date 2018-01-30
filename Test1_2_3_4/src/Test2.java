import java.util.*;
public class Test2
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("输入一串字符:");
		String str=sc.next();
		int aNum=0;
		int Anum=0;
		int other=0;
		char c;
		for(int i=0;i<str.length();i++){
			c=str.charAt(i);
			if(c>'a'&&c<'z'){
				aNum++;
			}
			if(c>'A'&&c<'Z'){
				Anum++;
			}else other++;
		}
		System.out.println("小写字符:"+aNum+"个。\n大写字符:"+Anum+"个。\n其它字符:"+other+"个。");
	}
}
