public class ColA implements Colleage
{
	String name;
	Mediator med;
	ColA(Mediator med){
		this.med=med;
		med.reColA(this);
	}
	public void giveMess(String[] mess)
	{
		med.delMess(this,mess);
	}
	public void reMess(String mess)
	{
		System.out.println(name+"收到的信息：");
		System.out.println("\t"+mess);
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
