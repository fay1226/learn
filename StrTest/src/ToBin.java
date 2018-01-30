/*
	问题：判断任意一个32位的十进制整数转换为二进制
		 后相同的字符个数。
	
	例如:十进制123456和456789转换成二进制分别为：
		  00000000000000011110001001000000
		  00000000000001101111100001010101
		其中共有23个字符相同，9个字符不同。
*/
import java.util.*;

public class ToBin
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("＞＞请输入2个整数：");
			int s1=sc.nextInt();
			int s2=sc.nextInt();
			String str1=Integer.toBinaryString(s1);
			String str2=Integer.toBinaryString(s2);
			char[] n1=str1.toCharArray();
			char[] n2=str2.toCharArray();
			int count=32;
			int size=Math.abs(n1.length-n2.length);
			char[] flp=n1.length>=n2.length?n2:n1;
			char[] flb=n1.length>=n2.length?n1:n2;
			for(int i=flp.length;i>0;i--){
				if(flp[i-1]!=flb[size+i-1]){
					count--;
				}
			}
			for(int j=size;j>0;j--){
				if(flb[j-1]!='0'){
					count--;
				}
			}
			System.out.println("二进制"+str1+"和"+str2+"中共有:");
			System.out.print(count+"个字符相同，");
			System.out.println((32-count)+"个字符不同。\n");
		}
	}
}
