import java.util.regex.*;
import java.util.*;

public class Crawler
{
	public static void main(String[] args){
		//String url = "https://image.baidu.com/wisehomepage/feeds/album?pn=1&setsign=243143981049276446&articleId=0&authorId=0&articleType=1&tn=wisefeed&fr=result&page=feedsubject&wd=%E7%BE%8E%E5%A5%B3&uistyle=2&logid=1457000912&feedsid=F8ACF34BFAEF927EA1628B599F695480&index=1&style=atlas3&apn=0&arn=10";
		//String regex = "<div class=\"atlas3 item\"(.+?)<h3>(\\S+)</h3>(.+?)<img src=\"(//hiphotos.baidu.com/image/\\S+)\">";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("title",2);
		map.put("url",4);
		String url="http://m.15tianqi.com/hangzhou/";
		StringBuffer sb = new StringBuffer();
		//当天天气
		String regex1="id=\"switchCity\" href=\"/\">(\\S+)<b class=\"switch\">(.+?)class=\"primary\">";
		String regex2="(.+?)class=\"phrase\">(\\S+)</div>(.+?)class=\"temperature\">(\\S+)</div>";
		String regex3="(.+?)id = \"realTimeTemp\">(\\S+)</div>(.+?)class=\"wind\">(\\S+)</div>";
		sb.append(regex1).append(regex2).append(regex3);
		String need_regex1=sb.toString();
		sb.setLength(0);
		//每天天气
		String regex4="class=\"date\">(.+?)</div>((.+?)height=\"25\"/>){2}(.+?)</div>";
		String regex5="(.+?)class=\"low\">(\\S+)</span>(.+?)class=\"high\">(\\S+)</span>";
		sb.append(regex4).append(regex5);
		String need_regex2=sb.toString();
		System.out.println(getResult(url,need_regex1,need_regex2));
		//System.out.println(Util.getHtml());
	}
	public static List<Map<String,String>> getResult(String url,Object ... params){
		String html = Util.getHtml(url);
		if(html == null){
			return null;
		}
		Pattern p = Pattern.compile(params[0].toString());
		Matcher m = p.matcher(html);
		Map<String,String> map = null;
		List<Map<String,String>> list = new LinkedList<Map<String,String>>();
		while(m.find()){
			map = new LinkedHashMap<String,String>();
			map.put("城市",m.group(1));
			map.put("天气",m.group(4));
			map.put("温度",m.group(6));
			map.put("风向",m.group(8)+","+m.group(10));
			list.add(map);
		}
		Pattern p1 = Pattern.compile(params[1].toString());
		Matcher m1 = p1.matcher(html);
		Map<String,String> map1=null;
		while(m1.find()){
			map1 = new LinkedHashMap<String,String>();
			map1.put("日期",m1.group(1));
			map1.put("天气",m1.group(4).trim());
			map1.put("气温",m1.group(6)+"~"+m1.group(8));
			list.add(map1);
		}
		return list;
	}
}
