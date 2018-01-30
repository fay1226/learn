import java.util.*;

class RandOther
{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("从几开始：");
		int sub=scan.nextInt();
		System.out.print("到几结束：");
		int sup=scan.nextInt();
		List list=randListOther(sub,sup);
		for(Object num:list){
			System.out.print(num+" ");
		}
		System.out.println("\n——————————华丽的分割线——————————");
		int[] math=randArrOther(sub,sup);
		for(int num:math){
			System.out.print(num+" ");
		}
		System.out.println("\n共产生"+(sup-sub)+"个数。");
	}
	public static List randListOther(int sub,int sup){
		List<Integer> math=new ArrayList<Integer>();
		int index=0;
		int count=sup-sub;
		Random random=new Random();
		while(index<count){
			int num=random.nextInt(count)+sub+1;
			if(!math.contains(num)){
				math.add(num);
				index++;
			}
		}
		return math;
	}
	public static int[] randArrOther(int sub,int sup){
		int count=sup-sub;
		int[] math=new int[count];
		int index=0;
		Random random=new Random();
		while(index<count){
			int num=random.nextInt(count)+sub+1;
			boolean flag=true;
			for(int i=0;i<math.length;i++){
				if(num==math[i]){
					flag=false;
					break;
				}
			}
			if(flag){
				math[index]=num;
				index++;
			}
		}
		return math;
	}
}
