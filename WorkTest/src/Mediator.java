public class Mediator
{
	ColA ca;
	ColB cb;
	public void reColA(ColA ca){
		this.ca=ca;
	}
	public void reColB(ColB cb){
		this.cb=cb;
	}
	public void delMess(Colleage colleage,String[] mess){
		if(colleage==ca){
			cb.reMess(colleage.getName()+mess[0]);
		}else if(colleage==cb){
			ca.reMess(colleage.getName()+mess[0]);
		}
	}
}
