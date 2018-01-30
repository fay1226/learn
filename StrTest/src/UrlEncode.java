import java.net.*;
import org.apache.commons.codec.*;
import java.io.*;
public class UrlEncode
{
	public static void main(String[] args) throws UnsupportedEncodingException{
		String str="你好！123-+*/,abc  ABC";
		String encode=getURLEncode(str);
		String decode=deCode(encode);
		System.out.println(encode+"\n"+decode);
	}
	public static String getURLEncode(String str) throws UnsupportedEncodingException{
		return URLEncoder.encode(str,"utf-8");
	}
	public static String deCode(String encode) throws UnsupportedEncodingException{
		return URLDecoder.decode(encode,"utf-8");
	}
}
