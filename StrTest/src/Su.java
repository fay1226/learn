import java.util.*;
/*m~n之间的素数*/
public class Su
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int sub=sc.nextInt();
		System.out.println("请输入一个整数：");
		int sup=sc.nextInt();
		System.out.println((sub>sup?sup:sub)+"到"+(sub>sup?sub:sup)+"的素数有:");
		sf(sub>sup?sub:sup);
		int count=0;
		for(int i=(sub>sup?sup:sub);i<=(sub>sup?sub:sup);i++){
			if(sf(i)&&i>1){
				count++;
				System.out.print(" "+i);
			}
		}
		System.out.println("\n共计"+count+"个。");
	}
	public static boolean sf(int i){
		for(int j=2;j<i;j++){
			if(i%j==0&&i!=2){
				return false;
			}
		}
		return true;
	}
}
