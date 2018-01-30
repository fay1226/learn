public class Game
{
	CalScore calScore;
	public void setCal(CalScore calScore){
		this.calScore=calScore;
	}
	public double doScore(double[] a){
		if(calScore!=null){
			return calScore.calScore(a);
		}else return 0;
	}
}
