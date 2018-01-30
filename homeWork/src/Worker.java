class Worker
{
	private String wNum,name;
	double money;
	String dept;
	//无参
	void worker(){
		wNum="T01";
		name="张三";
		money=8596.23;
		dept="A1";
		System.out.println("员工号:"+wNum+"\n姓名:"+name
		+"\n薪水:"+money+"\n部门:"+dept);
	}
	//单参
	void worker1(String w){
		this.wNum=w;
		System.out.println("\n部门:"+w);
	}
	//双参
	void worker2(String w,String n){
		this.wNum=w;
		this.name=n;
		System.out.println("\n员工号:"+w+"\n姓名:"+n);
	}
	//四参
	void worker3(String w,String n,double m,String d){
		this.wNum=w;
		this.name=n;
		this.money=m;
		this.dept=d;
		System.out.println("\n员工号:"+w+"\n姓名:"+n
		+"\n薪水:"+m+"\n部门:"+d);
	}
	public static void main(String[] args){
		Worker worker=new Worker();
		worker.worker();
		worker.worker1("A1");
		worker.worker2("A2","李小二");
		worker.worker3("A4","李四",9685.1,"T2");
	}
}
