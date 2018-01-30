import java.util.*;
import java.net.*;

public class Test
{
	public static void main(String[] args){
		for(int i=0;i<10;i++){
			Random ran=new Random();
			int t=ran.nextInt(3);//[0,3)
			int t1=(int)Math.pow(t,t);
			int ra=(int)(6*Math.random());//[0,6)
			System.out.print(ra+" "+t1+"\n");
		}
		char tu='9';
		System.out.println(tu+"的字节码为:"+(int)tu);
		int x=06;//8进制，包含[0,8),共8位
		int x0=0xF;//16进制，包含[0,9]和[a~f]可大写，共16位
		System.out.println(x+"\n"+x0);
		try{
			ServerSocket serv=new ServerSocket(9876);
			while(true){
				Socket soc=serv.accept();
				System.out.println("address："+soc.getInetAddress());
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("找不到。");
		}
	}
}
