import java.util.*;

class TransTest2
{
	public static void main(String[] args)
	{
		Trans trans=new Car2();
		trans.help();
		System.out.println("请选择车型:[1]表示汽车，[2]表示火车");
		Scanner scan=new Scanner(System.in);
		int type=scan.nextInt();
		if(type==1){
			System.out.print("你选择的是汽车。\n请输入汽车长度:");
			double length=scan.nextDouble();
			System.out.print("长度是"+length+"，走"+trans.highway);
			trans.show(length);
		}else if(type==2){
			trans= new Train2();
			System.out.print("你选择的是火车。\n走"+trans.railway);
			trans.show();
		}else System.out.println("输入有误！");
	}
}
class Trans
{
	public String highway="公路";
	public String railway="铁路";
	void show(){
		System.out.print("，很长");
	}
	void show(double length){
	}
	void help(){
		System.out.println("交通工具都可以帮助人类更高效的办事。");
	}
}

class Car2 extends Trans
{
	void show(double length){
		double speed=99.5;
		if(length<=4){
			String type="客车";
			System.out.print("，这是"+type+"，一般用于载人，速度是"+(speed+10));
		}else{
			String type="货车";
			System.out.print("，这是"+type+"，主要用于载物，速度是"+(speed-10));
		}
	}
}
class Train2 extends Trans
{
	double speed=100;
	void show()
	{
		super.show();
		String type="火车";
		System.out.println("，这是"+type+"，一次能载好多人和物，速度是"+speed);
	}
}
