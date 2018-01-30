import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String str=input.next();
		char c=str.charAt(0);//截取输入的第一个字符
		char[] d=str.substring(0,1).toCharArray();
		System.out.println(c+String.valueOf(d[0]));
		String str1="http://www.baidu.com";
		for(int i=0;i<str1.length();i++){
			System.out.print(str1.charAt(i)+" ");
		}
		System.out.println("\n"+str1.substring(str1.indexOf("www"),str1.indexOf("com")+3));
	}
}
