import java.util.*;

public class ToBin3
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("＞＞请输入2个整数:");
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			String str1=Integer.toBinaryString(num1);
			String str2=Integer.toBinaryString(num2);
			int count=32;
			String a=str1.length()>=str2.length()?str2:str1;
			String b=str1.length()>=str2.length()?str1:str2;
			for(int i=0;i<Math.abs(str1.length()-str2.length());i++){
				a="0"+a;
			}
			for(int j=0;j<a.length();j++){
				if(a.charAt(j)!=b.charAt(j)){
					count--;
				}
			}
			System.out.println("二进制"+a+"和"+b+"中共有:");
			System.out.print(count+"个字符相同，");
			System.out.println((32-count)+"个字符不同。\n");
		}
	}
}
