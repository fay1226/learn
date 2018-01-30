package com.runoob;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.net.*;
import android.widget.*;

public class WelcomeActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**全屏设置，隐藏窗口所有装饰**/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome_activity);
		Handler handler = new Handler();
		if (isNetworkAvailable(WelcomeActivity.this))
        {
            Toast.makeText(getApplicationContext(), "当前网络可用！", Toast.LENGTH_LONG).show();
			//当计时结束,跳转至主界面
			handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
						startActivity(intent);
						WelcomeActivity.this.finish();
					}
				}, 3000);
        }else{
            Toast.makeText(getApplicationContext(), "当前无可用网络！请联网后重试！", Toast.LENGTH_LONG).show();
			//当计时结束,跳转至主界面
			handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						System.exit(0);
					}
				}, 3000);
        }
	}
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context
			.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo info = connectivity.getActiveNetworkInfo();
			if (info != null && info.isConnected()) 
			{
				// 当前网络是连接的
				if (info.getState() == NetworkInfo.State.CONNECTED) 
				{
					// 当前所连接的网络可用
					return true;
				}
			}
		}
		return false;
	}
}
