import java.security.*;
import org.apache.http.entity.*;
import java.io.*;
import org.apache.http.util.*;
import java.util.*;
import java.math.*;

public class MD5
{
	public static void main(String[] args){
		while(true){
			System.out.println("请输入需要MD5加密的字符串：");
			Scanner sc=new Scanner(System.in);
			String str=sc.next();
			String resultTwo16=MD5(MD5(str).substring(8,24)).substring(10,26);
			String result16=MD5(str).substring(8,24);
			System.out.println("MD5加密："+MD5(str));
			System.out.println("MD5大写："+MD5(str).toUpperCase());
			System.out.println("MD5加密16位："+result16);
			System.out.println("MD5双重16位："+resultTwo16+"\n");
		}
	}
	public static String MD5(String s){
		StringBuffer sb=new StringBuffer();
		try{//SHA加密只需将MD5换为SHA(SHA-1同理)
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte[] mds=md.digest();
			for(byte b:mds){
				int bt=b&0xff;
				if(bt<16){
					sb.append(0);
				}
				sb.append(Integer.toHexString(bt));
			}
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return sb.toString();
	}
}
