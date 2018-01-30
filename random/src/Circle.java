import java.util.*;

public class Circle
{
	double r;
	final double PI=Math.PI;
	double S,C;
	double getS(){
		this.S=r*r*PI;
		return S;
	}
	double getC(){
		this.C=2*r*PI;
		return C;
	}
	void setR(double r){
		this.r=r;
	}
	void getInfo(){
		System.out.println("半径："+r+"\n面积："+S+"\n周长："+C);
	}
	public static void main(String[] args){
		Circle mycircle=new Circle();
		Scanner sc=new Scanner(System.in);
		System.out.println("输入圆的半径：");
		double r=sc.nextDouble();
		mycircle.setR(r);
		mycircle.getC();
		mycircle.getS();
		mycircle.getInfo();
	}
}
