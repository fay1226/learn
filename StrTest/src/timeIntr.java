import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class timeIntr
{
	public static void main(String[] args) throws Exception{
		String webUrl1 = "http://www.bjtime.cn";//bjTime
        String webUrl2 = "http://www.baidu.com";//百度
        String webUrl3 = "http://www.taobao.com";//淘宝
        String webUrl4 = "http://www.ntsc.ac.cn";//中国科学院国家授时中心
        String webUrl5 = "http://www.360.cn";//360
        String webUrl6 = "http://www.beijing-time.org";//beijing-time
		System.out.println(getWebsiteDatetime(webUrl1));
		System.out.println(getWebsiteDatetime(webUrl2));
		System.out.println(getWebsiteDatetime(webUrl3));
		System.out.println(getWebsiteDatetime(webUrl4));
		System.out.println(getWebsiteDatetime(webUrl5));
		System.out.println(getWebsiteDatetime(webUrl6));
		System.out.println(getWebsiteDatetime("http://m.blog.csdn.net") + "[中国科学院国家授时中心]");
	}
	private static String getWebsiteDatetime(String webUrl) throws Exception{
        try {
            URL url = new URL(webUrl);// 取得资源对象
            URLConnection uc = url.openConnection();// 生成连接对象
            uc.connect();// 发出连接
            long ld = uc.getDate();// 读取网站日期时间
            Date date = new Date(ld);// 转换为标准时间对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 输出北京时间
            return sdf.format(date);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
