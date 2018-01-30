import java.util.*;
import java.util.regex.*;

public class RegexUtils
{
	public static void main(String[] args){
		String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
		System.out.println(isRegex("15187878751",regex));
		
		String str = "\n\n你好!       今天是\n\n\n2018年 1月 11日\n星期四";
		System.out.println(removeBlank(str));
		
		List<String> list = new ArrayList<String>();
		list = getRegexGroup(str,"\\d+");
		System.out.println(list);
	}
	//匹配内容
	public static boolean isRegex(String str,String regex){
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(str);
		return matcher.matches();
	}
	//去除首行空行，多余空行和多余空格
	public static String removeBlank(String str){
		return str.replaceFirst("[\r\n]+","").replaceAll("[\r\n]+","\r\n").replaceAll("[ ]+"," ");
	}
	//返回匹配到的内容
	public static List<String> getRegexGroup(String str,String regex){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		List<String> list = new LinkedList<String>();
		String temp = null;
		while(matcher.find()){
			temp = matcher.group().trim();
			if(!temp.isEmpty()) list.add(temp);
		}
		return list;
	}
}
