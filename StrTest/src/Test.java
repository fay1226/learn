public class Test
{
	public static void main(String[] args){
		/*String s=null;
		 //System.out.println(s==null&&s.length()==0);
		 //System.out.println(s==null&s.length()==0);
		 System.out.println(s==null||s.length()==0);
		 //System.out.println(s==null|s.length()==0);
		 int a=5;
		 System.out.println(Integer.toBinaryString(~a)+" "+Integer.toBinaryString(a));
		 */
		/*Integer i=5;
		 Integer j=5;
		 System.out.println(i==j);//false
		 String s1="hello";
		 String s2="he"+new String("llo");
		 if(s1==s2) System.out.println("s1==s2");//false
		 if(s1.equals(s2)) System.out.println("s1.equals(s2)");//true
		 System.out.println(tryTest());//3
		 */
	}
	public static int tryTest(){
		try{
			return 1;
		}catch(Exception e){
			return 2;
		}finally{
			return 3;
		}
	}
}
