import java.util.*;
import java.io.*;

public class Genhao
{
	public static void main(String[] args){
		while(true){
			try{
				Runtime.getRuntime().exec("rundll32,FileHandler http://baidu.com");
			}catch(IOException e){
				System.err.println("找不到！");
			}
			System.out.print("请输入一个数:\n√");
			Scanner sc=new Scanner(System.in);
			double d=sc.nextDouble();
			System.out.println("√"+d+"="+Math.sqrt(d));
			System.out.println(2<<3);//2×2³(最大29次方)
			System.out.println(16>>3);//16÷2³
		}
	}
}
