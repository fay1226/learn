import java.net.*;
import java.io.*;
import java.util.*;

public class UrlObjTest
{
	public static void main(String[] args){
		String str="https://www.baidu.com";
		urlObjTest(str);
	}
	public static void urlObjTest(String str){
		BufferedReader br=null;
		FileWriter fw=null;
		BufferedWriter bw=null;
		try{
			URL url=new URL(str);
			URLConnection urlCon=url.openConnection();
			br=new BufferedReader(new InputStreamReader(urlCon.getInputStream(),"utf-8"));
			StringBuffer result=new StringBuffer();
			String read="";
			while((read=br.readLine())!=null){
				result.append(read+"\n");
			}
			
			File file=new File("/storage/emulated/0/AppProjects/random/src/"+UUID.randomUUID()+".html");
			if(!file.exists()){
				file.createNewFile();
			}
			fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
			bw.write(result.toString());
			System.out.println("写入成功。");
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null) br.close();
				if(fw!=null) fw.close();
				if(bw!=null) bw.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
