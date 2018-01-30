import java.io.*;
public class ReadFile
{
	public static void main(String[] args)
	{
		File file=new File("/storage/emulated/0/AppProjects/StrTest/src/Caladd.java");
		System.out.println(readFile(file));
	}
	public static String readFile(File file)
	{
		String str=null;
		StringBuffer sb = new StringBuffer();
		try{
			BufferedReader br=new BufferedReader(new FileReader(file));
			while ((str=br.readLine())!= null){
				sb.append(str);
			}
			br.close();
		}catch (IOException e){
			System.out.println("读取失败。");
		}
		return sb.toString();
	}
}
