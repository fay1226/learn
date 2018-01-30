import java.net.*;
import java.io.*;
import java.util.*;

public class PasswordCode
{
	public static void main(String[] args){
		String str ="青锋祝大家圣诞节快乐!";
		String psw=test2password(str);
		test2code(psw);
	}
	public static String test2password(String str){
		System.out.println("【——————加密——————】");
		System.out.println("明文:"+str);
		String unicode = str2unicode(str).replaceAll("\\\\","");
		System.out.println("Unicode码:"+str2unicode(str));
		String atbash = atbash(unicode);
		System.out.println("埃特巴什码:"+atbash);
		String morseCode = str2morse(atbash);
		System.out.println("摩斯电码:"+morseCode);
		String encode=null;
		try{
			encode = encode(morseCode);
			System.out.println("密文:"+encode);
		}catch (UnsupportedEncodingException e){}
		return encode;
	}
	public static void test2code(String str){
		System.out.println("\n【——————解密——————】");
		System.out.println("密文:"+str);
		try{
			String morseCode=deCode(str);
			System.out.println("摩斯电码:"+morseCode);
			String atbash=morse(morseCode);
			System.out.println("埃特巴什码:"+atbash);
			String unib=atbash(atbash.toLowerCase());
			String unicode = unib.toLowerCase().replaceAll("u","\\\\u");
			System.out.println("Unicode码:"+unicode);
			String s=unicode2str(unicode);
			System.out.println("明文:"+s);
		}catch (UnsupportedEncodingException e){}
	}
	//字符串转Unicode
	public static String str2unicode(String str){
		if(str==null) return null;
		char c;
		int j;
		String temp;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			sb.append("\\u");
			c = str.charAt(i);
			j = c >>> 8;
			temp = Integer.toHexString(j);
			if(temp.length()==1) sb.append("0");
			sb.append(temp);
			j = c & 0xFF;
			temp = Integer.toHexString(j);
			if(temp.length()==1) sb.append("0");
			sb.append(temp);
		}
		return sb.toString();
	}
	//Unicode转字符串
	public static String unicode2str(String unicode){
		StringBuffer sb = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for(int i=1;i<hex.length;i++){
			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i],16);
			sb.append((char)data);
		}
		return sb.toString();
	}
	//埃特巴什码加解密
	public static String atbash(String str){
		if(str==null) return null;
		char[] arr = str.toCharArray();
		char c;
		for(int i=0;i<arr.length;i++){
			c = arr[i];
			if((int)c>=97&&(int)c<=122){
				arr[i] = (char)(219 - c);
			}
		}
		return new String(arr).toUpperCase();
	}
	//Encode加密
	public static String encode(String str) throws UnsupportedEncodingException{
		if(str==null) return null;
		return URLEncoder.encode(str,"utf-8");
	}
	//Encode解密
	public static String deCode(String encode) throws UnsupportedEncodingException{
		if(encode==null) return null;
		return URLDecoder.decode(encode,"utf-8");
	}
	
	public static String[] morse = {"．━","━．．．","━ ．━．","━ ．．","．","．．━．",
	"━ ━．","．．．．","．．","．━ ━ ━","━ ．━","．━．．","━ ━","━．","━ ━ ━",
	"．━ ━．","━ ━．━","．━ ．","．．．","━","．．━","．．．━","．━ ━","━ ．．━",
	"━．━ ━","━ ━ ．．","—","• —","• • —","• — —","• • • —","• • •","— • • •",
	"— — •","— • •","— •","．━．━ ．━","━ ━ ━．．．","━ ━．．━ ━","━．━ ．━．",
	"．．━ ━．．","━ ．．．━","．━ ━ ━ ━ ．","━．．━ ．","━．━ ．━ ━","━．．．．━",
	"．．━ ━．━","．━ ．．━．","━ ．━ ━ ．","━．━ ━．━","．．．━ ．．━","．━ ．．．",
	"．━ ━．━ ．","．━．━．"};
	public static String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K",
	"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4",
	"5","6","7","8","9",".",":",",",";","?","=","'","/","!","━","-","\"","(",")",
	"$","&","@","+"};
	//字符串转摩斯电码
	public static String str2morse(String str){
		if(str==null) return null;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			String temp = String.valueOf(str.charAt(i));
			for(int j=0;j<alphabet.length;j++){
				String s = alphabet[j];
				if(s.equals(temp)){
					sb.append(morse[j]+"/");
					break;
				}
			}
		}
		return sb.toString();
	}
	//摩斯电码解码
	public static String morse(String morseCode){
		if(morseCode==null) return null;
		String[] m = morseCode.split("/");
		StringBuilder sb = new StringBuilder();
		for(String temp:m){
			for(int i=0;i<morse.length;i++){
				if(morse[i].equals(temp)){
					sb.append(alphabet[i]);
					break;
				}
			}
		}
		return sb.toString();
	}
}
