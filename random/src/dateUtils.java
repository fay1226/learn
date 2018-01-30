import java.util.*;
import java.text.*;

public class dateUtils
{
	public static Date stringToDate(String str,String format) throws ParseException{
		return new SimpleDateFormat(format).parse(str);
	}
	public static String dateToString(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}
	public static void main(String[] args) throws ParseException{
		System.out.println(stringToDate("2014-12-26 12:32:46","yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateToString(new Date(),"yyyy.MM.dd HH:mm:ss"));
	}
}
