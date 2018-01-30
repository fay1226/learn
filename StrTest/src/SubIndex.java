public class SubIndex
{
	public static void main(String[] args){
		String str="abcdefg123456";
		String sub=str.substring(str.lastIndexOf("cde"),str.length()-1);
		System.out.println(sub);
	}
}
