import java.util.*;

public class InsertShort
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("输入排序个数：");
		int len=sc.nextInt();
		double[] d=new double[len];
		for(int i=0;i<d.length;i++){
			d[i]=100*Math.random();
		}
		System.out.println("原始数组为：");
		outArray(d);
		outArray(inShort(d));
		double[] dq={5,7,54,28,1,8,52,4,12,6,5,17};
		outArray(inShort(dq));
	}
	//插入排序
	public static double[] inShort(double[] arr){
		long startTime=System.nanoTime();
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++){
				double temp=arr[j];
				if(arr[j]>arr[j+1]){
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		long endTime=System.nanoTime();
		System.out.println("\n\n执行时间："+(endTime-startTime)+"ns(纳秒)"+"\n\n排序结果为：");
		return arr;
	}
	//输出数组
	public static void outArray(double[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.printf("%.2f",arr[i]);
			System.out.print(" ");
		}
	}
}
