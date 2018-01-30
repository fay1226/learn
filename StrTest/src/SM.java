public class SM
{
	public static void main(String[] args){
		double[] shorted={5,7,54,28,1,8,52,4,12,6,5,17};
		double[] d=doSM(shorted);
		for(int i=0;i<d.length;i++){
			System.out.print(d[i]+" ");
		}
	}
	public static double[] doSM(double[] shorted){
		for(int i=0;i<shorted.length-1;i++){
			for(int j=i+1;j<shorted.length;j++){
				double d1=shorted[i];
				if(shorted[i]<shorted[j]){
					shorted[i]=shorted[j];
					shorted[j]=d1;
				}
			}
		}
		return shorted;
	}
}
