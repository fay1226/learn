public class StringTest
{
	public static void main(String[] args){
		String str1="Hello World!";
		String str2="Hello World!";
		String str="Hi World!";
		String str3=new String("Hello World!");
		String str4=new String("Hello World!");
		System.out.println(str1==str2);//true
		System.out.println(str1.equals(str2));//true
		System.out.println(str1==str);//false
		System.out.println(str1.equals(str));//false
		System.out.println(str3==str4);//false
		System.out.println(str1==str3);//false
		System.out.println(str1.equals(str3));//true
		System.out.println(str3.equals(str4));//true
		System.out.println(str2==String.valueOf(str1));//true
		System.out.println(str1==str2.toString());//true
		System.out.println(str1.toString()==String.valueOf(str2));//true
		System.out.println(str1.toString().equals(str2));//true
		System.out.println(str3.toString()==str1);//false
		System.out.println(String.valueOf(str3)==str1);//false
		System.out.println(String.valueOf(str3).equals(str1));//true
	}
}
