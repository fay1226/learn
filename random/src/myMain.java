public class myMain
{
	public static void main(String[] args)
	{
		CalTest cal=new CalTest();
		double left=0;
		double right=2*Math.PI;
		double x=(right+left)/2;
		double d=0.00000001;
		double y1=2*x*Math.cos(x*x);
		cal.cal(left,right,d,y1);
	}
}
