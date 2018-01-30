import java.util.*;

public class ListShort
{
	public void doSort(){
        List<String> list=new ArrayList<String>();
        String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random=new Random();
		System.out.println("待添加的字符串：");
        for(int i=0;i<10;i++){
            StringBuffer st=new StringBuffer();
            Integer lg;
            do{
                lg=random.nextInt(9)+1;//随机生成字符串长度
                for(int j=0;j<lg;j++){
                    st.append(str.charAt(random.nextInt(62)));//从str中随机取出单个字符加入st中
                }
            }while(list.contains(st));//无重复字符串
            list.add(st.toString());
			System.out.print(" "+st);
        }
        System.out.println("\n排序前：\n"+list);
        Collections.sort(list);
        System.out.println("\n排序后：");
        for(String flag:list){
            System.out.print(" "+flag);
        }
		System.out.println("\n结果为：\n"+list);
    }
    public static void main(String[] args) {
        ListShort ls=new ListShort();
        ls.doSort();
    }
}
