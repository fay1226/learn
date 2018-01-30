public class cal
{
	//打印九九乘法表
	public static void main(String[] args){
		System.out.println("—————————————————————————————九九乘法表————————————————————————————————\n");
		StringBuilder sb=new StringBuilder();
		int sum;
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				sum=i*j;
				sb.append(j+"×"+i+"="+sum+" ");
				if(j>=2&&sum<10){
					sb.append(" ");
				}
			}
			sb.append("\n\n");
		}
		System.out.print(sb.toString());
	}
}
