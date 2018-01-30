import java.util.*;

public class Method
{
	public void runElev(LinkedList<People> list,Elev elev){
		LinkedList<People> inList = new LinkedList<People>();//进入电梯的人
		Method m = new Method();
		int elevLocal;//电梯当前楼层
		int local;//人所在楼层
		int toLocal;//人要去的楼层
		//如果有人乘电梯，开始执行
		int count=0;
		while(!list.isEmpty()&&count<10){
			elev.setIsWait(false);
			//检测该楼层是否有到达乘客
			inList = m.outElev(inList,elev);
			m.isUp(list,inList,elev);
			//检测该楼层是否有等待乘客
			list = m.inElev(list,inList,elev);
			//遍历所有乘电梯的人
			for(int i=0;i<list.size();i++){
				People p=list.get(i);
				local = p.getLocal();
				elevLocal = elev.getLocal();
				upOrDown(elevLocal,local,elev,list,inList);
			}
			//如果电梯里还有人
			while(!inList.isEmpty()&&count<10){
				//检测该楼层是否有到达乘客
				inList = m.outElev(inList,elev);
				m.isUp(list,inList,elev);
				//检测该楼层是否有等待乘客
				list = m.inElev(list,inList,elev);
				for(int i=0;i<inList.size();i++){
					People p=inList.get(i);
					toLocal = p.getToLocal();
					elevLocal = elev.getLocal();
					upOrDown(elevLocal,toLocal,elev,list,inList);
				}
			}
			count++;
		}
		//elev.setIsUp(true);
		elev.setIsWait(true);
		System.out.println(elev);
	}
	private static void upOrDown(int elevLocal,int local,Elev elev,LinkedList<People> list,LinkedList<People> inList){
		//如果有人等待电梯，电梯当前楼层小于人所在楼层，电梯上升
		//如果没有人等待，且电梯里还有人，电梯当前楼层小于人要去的楼层，电梯上升
		Method m = new Method();
		while(elev.isUp()&&elevLocal<local&&elev.getLocal()<elev.height){
			elev.setLocal(1);
			//elev.setIsUp(true);
			elevLocal = elev.getLocal();
			System.out.println(elevLocal+elev.isUpToString());
			//检测该楼层是否有到达乘客
			inList = m.outElev(inList,elev);
			m.isUp(list,inList,elev);
			//检测该楼层是否有等待乘客
			list = m.inElev(list,inList,elev);
		}
		//如果有人等待电梯，电梯当前楼层大于人所在楼层，电梯下降
		//如果没有人等待，且电梯里还有人，电梯当前楼层大于人要去的楼层，电梯下降
		while(elevLocal>local&&elev.getLocal()>-1){
			elev.setLocal(-1);
			//elev.setIsUp(false);
			elevLocal = elev.getLocal();
			System.out.println(elevLocal+elev.isUpToString());
			//检测该楼层是否有到达乘客
			inList = m.outElev(inList,elev);
			m.isUp(list,inList,elev);
			//检测该楼层是否有等待乘客
			list = m.inElev(list,inList,elev);
		}
	}
	//进电梯
	/*private LinkedList<People> inElev(LinkedList<People> list,LinkedList<People> inList,Elev elev){
		LinkedList<People> delList = new LinkedList<People>();
		if(!list.isEmpty()){
			for(People p:list){
				//如果电梯楼层等于人的楼层，且电梯的方向和人去的方向相同，则进入电梯
				if(p.getLocal()==elev.getLocal()&&(elev.isUp()==(p.getToLocal()>p.getLocal()))){
					inList.add(p);
					delList.add(p);
					System.out.println("当前楼层为"+elev.getLocal()+"\t"+p.getName() + "进入电梯。"+elev.isUpToString());
					elev.setIsWait(false);
				}
			}
			list.removeAll(delList);
		}
		return list;
	}*/
	private LinkedList<People> inElev(LinkedList<People> list,LinkedList<People> inList,Elev elev){
		if(!list.isEmpty()){
			for(int i=0;i<list.size();i++){
				//如果电梯楼层等于人的楼层，且电梯的方向和人去的方向相同，则进入电梯
				People p=list.get(i);
				if(p.getLocal()==elev.getLocal()&&(elev.isUp()==(p.getToLocal()>p.getLocal()))){
					inList.add(p);
					list.remove(p);
					System.out.println("当前楼层为"+elev.getLocal()+"\t"+p.getName() + "进入电梯。"+elev.isUpToString());
					elev.setIsWait(false);
				}
			}
		}
		return list;
	}
	//出电梯
	/*private LinkedList<People> outElev(LinkedList<People> inList,Elev elev){
		LinkedList<People> delList = new LinkedList<People>();
		if(!inList.isEmpty()){
			for(People p:inList){
				if(p.getToLocal()==elev.getLocal()){
					delList.add(p);
					System.out.println("当前楼层为"+elev.getLocal()+"\t"+p.getName() + "出了电梯。"+elev.isUpToString());
				}
			}
			inList.removeAll(delList);
		}
		return inList;
	}*/
	private LinkedList<People> outElev(LinkedList<People> inList,Elev elev){
		if(!inList.isEmpty()){
			for(int i=0;i<inList.size();i++){
				People p = inList.get(i);
				if(p.getToLocal()==elev.getLocal()){
					inList.remove(p);
					System.out.println("当前楼层为"+elev.getLocal()+"\t"+p.getName() + "出了电梯。"+elev.isUpToString());
				}
			}
		}
		return inList;
	}
	public static void isUp(LinkedList<People> list,LinkedList<People> inList,Elev elev){
		for(People p:list){
			if(p.getLocal()<p.getToLocal()){
				elev.setIsUp(true);
				break;
			}else elev.setIsUp(false);
		}
		for(People p:inList){
			if(p.getLocal()>p.getToLocal()){
				elev.setIsUp(false);
				break;
			}else elev.setIsUp(true);
		}
	}
}
