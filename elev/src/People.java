public class People
{
	private String name;//姓名
	private int local;//所在楼层
	private int toLocal;//去几楼

	public People(){}
	public People(String name,int local,int toLocal){
		this.name = name;
		//所在楼层最高不超过电梯高度，最低不低于电梯最底
		if(local>Elev.height){
			this.local = Elev.height;
			System.out.println(name+"最高只能在"+Elev.height+"层乘坐。");
		}else if(local<Elev.floor){
			this.local = Elev.floor;
			System.out.println(name+"最低只能在"+Elev.floor+"层乘坐。");
		}else this.local = local;
		//所去楼层最高不超过电梯高度，最低不低于电梯最底
		if(toLocal>Elev.height){
			this.toLocal = Elev.height;
			System.out.println(name+"最多只能到"+Elev.height+"层。");
		}else if(toLocal<Elev.floor){
			this.toLocal = Elev.floor;
			System.out.println(name+"最低只能到"+Elev.floor+"层。");
		}else this.toLocal = toLocal;
	}
	public void setToLocal(int toLocal){
		//所去楼层最高不超过电梯高度，最低不低于电梯最底楼
		if(toLocal>Elev.height){
			this.toLocal = Elev.height;
			System.out.println(name+"最多只能到"+Elev.height+"层。");
		}else if(toLocal<Elev.floor){
			this.toLocal = Elev.floor;
			System.out.println(name+"最低只能到"+Elev.floor+"层。");
		}else this.toLocal = toLocal;
	}
	public int getToLocal(){
		return toLocal;
	}

	public void setLocal(int local){
		//所在楼层最高不超过电梯高度，最低不低于电梯最底
		if(local>Elev.height){
			this.local = Elev.height;
			System.out.println(name+"最高只能在"+Elev.height+"层乘坐。");
		}else if(local<Elev.floor){
			this.local = Elev.floor;
			System.out.println(name+"最低只能在"+Elev.floor+"层乘坐。");
		}else this.local = local;
	}
	public int getLocal(){
		return local;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	@Override
	public String toString(){
		return "P["+ this.getName() + "," + this.getLocal() + "→" + this.getToLocal() +"]";
	}
}
