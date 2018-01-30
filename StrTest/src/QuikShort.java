import java.util.*;

public class QuikShort
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("输入排序个数：");
		int len=sc.nextInt();
		double[] d=new double[len];
		for (int i=0;i < d.length;i++)
		{
			d[i] = 100 * Math.random();
		}
		System.out.println("原始数组为：");
		outArray(d);
		int left=0;
		int right=d.length - 1;
		quikShort(d, left, right);
		System.out.println("\n排序后结果：");
		outArray(d);
		double[] dq={5,7,54,28,1,8,52,4,12,6,5,17};
		quikShort(dq, 0, dq.length-1);
		System.out.println("\n排序后结果：");
		outArray(dq);
	}
	//快速排序
	public static void quikShort(double[] arr, int L, int R)
	{
		int left = L;
		int right = R;
		double flag = arr[L];
		while (right > left)
		{
			//从后往前比较
			while (right > left && arr[right] >= flag)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				right--;
			if (arr[right] <= flag){
				double temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
			}
			//从前往后比较
			while (right > left && arr[left] <= flag)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                left++;
			if (arr[left] >= flag){
				double temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			//此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		//递归
		if (left > L) quikShort(arr, L, left - 1);//左边序列。第一个索引位置到关键值索引-1
		if (right < R) quikShort(arr, right + 1, R);//右边序列。从关键值索引+1到最后一个
	}
	//输出数组
	public static void outArray(double[] arr)
	{
		for (int i=0;i < arr.length;i++)
		{
			System.out.printf("%.2f", arr[i]);
			System.out.print(" ");
		}
	}
}
