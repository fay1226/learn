import java.util.*;

public class numGame
{
	public static void main(String[] args){
		System.out.println("可以开始游戏了。输入0结束本次游戏。");
		numGM();
	}
	public static void numGM(){
		Random ran=new Random();
		int ranNum=ran.nextInt(99)+1;//产生的数
		int m=0;//初始化猜的次数
		System.out.println("猜数游戏[1～100]");
		int inNum=1;
		while(inNum>0){
			m++;
			System.out.print("\n我猜:");
			Scanner s=new Scanner(System.in);
			inNum=s.nextInt();
			if(inNum>100){
				System.out.println("笨蛋！猜1～100的数。");
			}else if(inNum>ranNum){
				System.out.println("猜大了！猜一个小于"+inNum+"的数。");
			}else if(inNum<ranNum){
				System.out.println("猜小了！猜一个大于"+inNum+"的数。");
			}else{
				System.out.print("恭喜你"+m+"次猜对，幸运指数:");
				switch(m){
					case 1:System.out.println("★★★★★\n可以买彩票去了！");break;
					case 2:
					case 3:System.out.println("★★★★☆\n超神了！");break;
					case 4:
					case 5:
					case 6:System.out.println("★★★☆☆\n还不错哦！");break;
					case 7:System.out.println("★★☆☆☆\n还不错哦！");break;
					default:System.out.println("★☆☆☆☆\n不敢想象。");break;
				}
				break;
			}
		}
		System.out.print("\n新的");
		numGM();
	}
}
