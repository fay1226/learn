import java.util.*;

public class abcCS
{
	public static void main(String[] args){
		scs();
	}
	public static void scs(){
		Scanner scan=new Scanner(System.in);
		System.out.print("输入三角形三边:\na=");
		double a=scan.nextDouble();
		System.out.print("b=");
		double b=scan.nextDouble();
		System.out.print("c=");
		double c=scan.nextDouble();
		if(a+b>c&&a+c>b&&b+c>a){
			double C=a+b+c;
			double S=Math.sqrt(C*(C-a)*(C-b)*(C-c));
			System.out.printf("三角形周长C=%.2f",C);
			System.out.printf("\n三角形面积S=%.2f",S);
			System.out.println("\n");
			scs();
		}else{
			System.out.print("指定的三边不能构成三角形！\n\n重新");
			scs();
		}
	}
}
