import java.util.*;
import java.net.*;
import java.io.*;

public class Util
{
	public static String getHtml(String url){
		InputStream is = null;
		try{
			URL getUrl = new URL(url);
			is = getUrl.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while((temp = br.readLine()) != null){
				sb.append(temp);
			}
			return sb.toString();
		}catch (Exception e){
			return null;
		}finally{
			if(is != null){
				try{
					is.close();
				}catch (IOException e){}
			}
		}
	}
}
