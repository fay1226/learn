public class Test
{
	public static void main(String[] args)
	{
		Game g=new Game();
		g.setCal(new CalOne());
		Person z=new Person();
		z.setName("张三");
		double[] a={9.12,8.25,8.97,9.89,7.97,8.89};
		z.setScore(g.doScore(a));
		Person l=new Person();
		l.setName("李四");
		double[] b={9.15,9.26,8.97,9.89,5.97,8.89};
		l.setScore(g.doScore(b));
		System.out.println("算术平均值方案：");
		System.out.printf(z.getName()+"最后得分：%.3f",z.getScore());
		System.out.printf("\n"+l.getName()+"最后得分：%.3f",l.getScore());
		System.out.println(z.getScore()>l.getScore()?"\t张三胜":"\t李四胜");
		g.setCal(new CalTwo());
		z.setScore(g.doScore(a));
		l.setScore(g.doScore(b));
		System.out.println("\n(去掉最高分，最低分)算术平均值方案：");
		System.out.printf(z.getName()+"最后得分：%.3f",z.getScore());
		System.out.printf("\n"+l.getName()+"最后得分：%.3f",l.getScore());
		System.out.println(z.getScore()>l.getScore()?"\t张三胜":"\t李四胜");
	}
}
