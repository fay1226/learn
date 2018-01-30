public class HexTest
{
	public static void main(String[] args){
		int num=192;
		System.out.println(toBinaryString(num,2));
	}
	public static String toBinaryString(int num,int hex){
		String result;
		switch(hex){
			case 2:result=Integer.toBinaryString(num);break;
			case 8:result=Integer.toOctalString(num);break;
			case 16:result=Integer.toHexString(num);break;
			default:result=Integer.toString(num,hex);break;
		}
		return result;
	}
}
