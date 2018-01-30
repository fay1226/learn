import java.util.Timer;
import java.util.TimerTask;

public class Jtime
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		final long time = System.currentTimeMillis();
		TimerTask task = new TimerTask() {
			@Override
			public void run()
			{
				String str = String.format("%1$tM:%1$tS:%1$1tL", System.currentTimeMillis() - time);
				System.out.println(str.substring(0, 7));
			}
		};
		new Timer().schedule(task, 1, 100);
	}
}
