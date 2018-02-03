import java.util.regex.*;
import java.util.*;

public class Crawler
{
	public static void main(String[] args){
		String url = "https://image.baidu.com/wisehomepage/feeds/album?pn=1&setsign=243143981049276446&articleId=0&authorId=0&articleType=1&tn=wisefeed&fr=result&page=feedsubject&wd=%E7%BE%8E%E5%A5%B3&uistyle=2&logid=1457000912&feedsid=F8ACF34BFAEF927EA1628B599F695480&index=1&style=atlas3&apn=0&arn=10";
		String regex = "<div class=\"atlas3 item\"(.+?)<h3>(\\S+)</h3>(.+?)<img src=\"(//hiphotos.baidu.com/image/\\S+)\">";
		System.out.println(getResult(url,regex));
	}
	public static List<Map<String,String>> getResult(String url,String regex){
		String html = Util.getHtml(url);
		if(html == null){
			return null;
		}
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(html);
		Map<String,String> map = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		while(m.find()){
			map = new HashMap<String,String>();
			map.put("title",m.group(2));
			map.put("url",m.group(4));
			list.add(map);
		}
		return list;
	}
}
