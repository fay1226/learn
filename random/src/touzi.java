import java.util.*;

public class touzi
{
	public static void main(String[] args){
		guzi();
	}
	public static void guzi(){
		Scanner scan=new Scanner(System.in);
		System.out.println("开局！请输入骰子个数:");
		int g=scan.nextInt();//骰子个数(0,15]
		if(g>0&&g<=10){
			String s="①②③④⑤⑥";
			int num=0;
			int zd=3*g;//点数比较值
			System.out.println("点数为:");
			for(int i=0;i<g;i++){
				int rm=(int)(s.length()*Math.random());//[0,6)
				System.out.print(s.charAt(rm)+" ");
				num=num+rm+1;//点数和
			}if(num>zd){
				System.out.print("\n"+num+"点＞"+zd+"点\n▲大");
			}else System.out.print("\n"+num+"点＜"+(zd+1)+"点\n△小");
		}else{
			System.out.println("→错误！输入1-10之内的个数。\n");
			guzi();
		}
		System.out.print("\n\n重新");
		guzi();
	}
}
