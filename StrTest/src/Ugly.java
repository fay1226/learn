/*
  执行以下ASIC伪代码(每个ASIC码用_分隔)，并写出执行结果。
	112_117_98_108_105_99_32_99_108_97_
 	115_115_32_84_101_115_116_123_10_9_
 	112_117_98_108_105_99_32_115_116_97_
 	116_105_99_32_118_111_105_100_32_109_
 	97_105_110_40_83_116_114_105_110_103_
 	91_93_32_97_114_103_115_41_123_10_9_
	9_83_121_115_116_101_109_46_111_117_
	116_46_112_114_105_110_116_108_110_40_
	34_72_101_108_108_111_44_87_111_114_
	108_100_33_34_41_59_10_9_125_10_125_
*/
import java.util.*;

public class Ugly
{
	public static void main(String[] args){
		String str="public class Test{\n\tpublic static void main(String[] args){\n\t\tSystem.out.println(\"Hello,World!\");\n\t}\n}";
		int i=0;
		System.out.println(i+".原始数据：\n"+str);
		Ugly u=new Ugly();
		System.out.println("编码后数据：");
		System.out.println(u.reStr(u.toASIC(str,"_"),"_"));
		Scanner sc=new Scanner(System.in);
		while(true){
			i++;
			System.out.println("\n"+i+".输入需要转码的字符：");
			String string=sc.next();
			System.out.println("编码后数据：");
			System.out.println(u.reStr(u.toASIC(string,"_"),"_"));
		}
	}
	public String toASIC(String str,String cut){
		StringBuffer sb=new StringBuffer();
		for	(int i=1;i<str.length()+1;i++){
			char m=str.charAt(i-1);
			sb.append((int)m+cut);
			System.out.print((int)m+cut);
			if(i%10==0){
				System.out.println();
			}
		}
		return sb.toString();
	}
	public String reStr(String str,String cut){
		StringBuffer sb=new StringBuffer();
		String[] strInt=str.split(cut);
		for(int i=0;i<strInt.length;i++){
			char cstr=(char)Integer.parseInt(strInt[i]);
			sb.append(cstr);
		}
		System.out.println("\n译码后数据：");
		return sb.toString();
	}
}
