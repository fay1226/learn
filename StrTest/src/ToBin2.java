import java.util.*;

public class ToBin2
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
			String a=str1;
			String b=str2;
			int count=0;
			for(int i=0;i<32-str1.length();i++){
				a="0"+a;
			}
			for(int i=0;i<32-str2.length();i++){
				b="0"+b;
			}
			for(int j=0;j<32;j++){
				if(a.charAt(j)==b.charAt(j)){
					count++;
				}
			}
			System.out.println("二进制"+a+"和"+b+"中共有:");
			System.out.print(count+"个字符相同，");
			System.out.println((32-count)+"个字符不同。\n");
		}
	}
}
