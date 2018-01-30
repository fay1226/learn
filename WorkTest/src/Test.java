public class Test
{
	public static void main(String[] args)
	{
		Mediator mediator=new Mediator();
		ColA ca=new ColA(mediator);
		ColB cb=new ColB(mediator);
		ca.setName("A国");
		cb.setName("B国");
		String[] messA={"要求归还曾夺走的100斤土地。"};
		ca.giveMess(messA);
		String[] messB={"要求归还曾夺走的10只公鸡。"};
		cb.giveMess(messB);
	}
}
