import java.util.*;
/*m~n之间的素数*/
public class Su2
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个整数:");
		int sub=sc.nextInt();
		System.out.println("请输入一个整数:");
		int sup=sc.nextInt();
		System.out.println((sub>sup?sup:sub)+"到"+(sub>sup?sub:sup)+"的素数有:");
		su(sub>sup?sup:sub,sub>sup?sub:sup);
	}
	public static void su(int sub,int sup){
		int count=0;
		boolean b;
		for(int i=sub;i<=sup;i++){
			b=true;
			for(int j=2;j<i;j++){
				if(i%j==0&&i!=2){
					b=false;
				}
			}
			if(b&&i>1){
				count++;
				System.out.print(i+" ");
			}
		}
		System.out.println("\n共计"+count+"个。");
	}
}
