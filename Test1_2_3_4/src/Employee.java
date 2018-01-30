public class Employee
{
	private String name;
	private String no;
	private double baseMoney;
	private double up;
	
	Employee(String name,String no,double baseMoney,double up){
		this.name=name;
		this.no=no;
		this.baseMoney=baseMoney;
		this.up=up;
	}
	public void setUp(double up){
		this.up=up;
	}
	public String getName(){
		return name;
	}
	public String getNo(){
		return no;
	}
	public double getBaseMoney(){
		return baseMoney;
	}
	public double calMoney(){
		baseMoney=baseMoney+baseMoney*up/100;
		return baseMoney;
	}
	public static void main(String[] args){
		Employee em=new Employee("范青锋","12141303",9888,1);
		System.out.println("姓名："+em.getName()+"\n工号："+em.getNo()+"\n基本工资："+em.baseMoney+"\n总工资："+em.calMoney());
		em.setUp(3);
		System.out.println("增长额:"+em.up+"%");
		System.out.printf("增额后工资：%.2f",em.calMoney());
	}
}
