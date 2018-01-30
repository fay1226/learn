import java.util.*;

public class Test1
{
	public static void main(String[] args)
	{
		System.out.println("请输入10个数:");
		Scanner sc= new Scanner(System.in);
		int[] a=new int[10];
		for(int i=0;i<a.length;i++){
			System.out.println("输入第"+(i+1)+"个数:");
			a[i]=sc.nextInt();
		}
		System.out.println("输入要查找的数:");
		int b=sc.nextInt();
		int j=0;
		boolean f=false;
		while(j<a.length){
			if(b==a[j]){
				f=true;
				break;
			}else{
				f=false;
				j++;
			}
		}
		if(f==true) System.out.println("存在。");
		else System.out.println("不存在。");
	}
}
