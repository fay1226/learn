public class ColB implements Colleage
{
	String name;
	Mediator med;
	ColB(Mediator med){
		this.med=med;
		med.reColB(this);
	}
	public void giveMess(String[] mess)
	{
		med.delMess(this,mess);
	}
	public void reMess(String mess)
	{
		System.out.println(name+"收到的消息：");
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
