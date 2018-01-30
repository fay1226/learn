
import java.util.*;public class Now
{
	public static void main(String[] args){
		/*String s1="hello";
		String s2="hello";
		System.out.println(s1==s2);//true
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.equals(new String("hello")));//true
		System.out.println(s1==new String("hello"));
		char[] c={'h','e','l','l','o'};
		System.out.println(c);//hello
		System.out.println(s1.equals(c));//false
		int[] s3={1,2,3,4};
		System.out.println(s3);
		String str=null;
		System.out.println(str!=null&str.length()>0);
		try{
			System.out.println("hello");
		}finally{
			System.out.println("world");
		}*/
		Integer a=new Integer(123);
		Integer b=new Integer(123);
		Integer c=123;
		int d=123;
		System.out.println(a==b);//false
		System.out.println(a==c);//false
		System.out.println(a==d);//true
		System.out.println(c==d);//true
	}
}
