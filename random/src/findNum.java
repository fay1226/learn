import java.util.*;

public class findNum
{
	public static void main(String[] args){
		fNum();
	}
	public static void fNum(){
		Random rand=new Random();
		int r=rand.nextInt(100);
		System.out.println("电脑生成(0～100):"+r);
		int n=0,m=100;
		int index=0;
		while(r!=0&&r!=100){
			Random ran=new Random();
			int num=ran.nextInt(m-n)+n;  
			if(num!=m&&num!=n){
				index++;
				System.out.print(" "+num);
			}
			if(num>r){
				m=num;
			}else if(num<r){
				n=num;
			}else{
				System.out.println("\n经过"+index+"次找出:"+r);
				break;
			}
		}
	}
}
