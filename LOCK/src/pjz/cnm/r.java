package pjz.cnm;

import android.content.*;

public class r extends BroadcastReceiver
{

	@Override
	public void onReceive(Context p1, Intent p2)
	{
		// TODO: Implement this method
		
		if(p2.getAction().equals("android.intent.action.BOOT_COMPLETED"))
		{
			abortBroadcast();
			Intent intt=new Intent(p1,s.class);
			p1.startService(intt);
			
		}
	}

}
