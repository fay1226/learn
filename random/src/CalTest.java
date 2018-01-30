public class CalTest
{
	public void cal(double left,double right,double d,double y1){
		int count=0;
		double x=(right+left)/2;
		while((right-left)>d){
			y1=2*x*Math.cos(x*x);
			if(y1==0){
				break;
			}else if(y1>0){
				right=x;
			}else{
				left=x;
			}
			x=(right+left)/2;
			count++;
		}
		System.out.println("迭代次数:"+count);
		System.out.printf("当x=%.4f",x);
		System.out.printf("时，\n最小值y=%5.4f",Math.sin(x*x));
	}
}
