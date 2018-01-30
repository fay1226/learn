public class TabNN
{
	public static void main(String[] args){
		nn();
	}
	public static void nn(){
		int n=0,m=0;
		int mn=0;
		String s="====";
		for(int i=0;i<3;i++){
			n=n*10+9;
			for(int j=0;j<2;j++){
				m=m*10+9;
				mn=n*m;
				System.out.println(s+n+"×"+m+"="+mn+" ");
			}
		}
	}
}
