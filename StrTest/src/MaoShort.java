import java.util.*;

public class MaoShort
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
		outArray(maoShort(d));
		double[] dq={5,7,54,28,1,8,52,4,12,6,5,17};
		outArray(maoShort(dq));
	}
	//冒泡排序
	public static double[] maoShort(double[] arr){
		long startTime=System.nanoTime();
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				double temp=arr[i];
				if(arr[i]>arr[j]){
					arr[i]=arr[j];
					arr[j]=temp;
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
