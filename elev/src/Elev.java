import java.util.*;

public class Elev
{
	final public static int height = 20;//最高20楼
	final public static int floor = -1;//最低地下2楼
	private int local;//电梯当前位置
	private boolean isUp;//是否上升
	private boolean isWait;//是否在等待
	public Elev(){}
	public Elev(int local,boolean isUp,boolean isWait){
		this.local = local;
		this.isUp = isUp;
		this.isWait = isWait;
	}

	public void setLocal(int port){
		this.local += port;
	}
	public int getLocal(){
		return local;
	}
	
	public void setIsUp(boolean isUp){
		this.isUp = isUp;
	}
	public String isUpToString(){
		return isWait?"↑↓":isUp?"↑":"↓";
	}
	public boolean isUp(){
		return isUp;
	}

	public void setIsWait(boolean isWait){
		this.isWait = isWait;
	}
	public boolean isWait(){
		return isWait;
	}

	@Override
	public String toString(){
		return "E[当前楼层:"+ this.getLocal() + ",当前状态:" + this.isUpToString() + ",等待乘客:" + (this.isWait()?"是":"否") + "，最高:" + height + "层]";
	}
}
