package com.fancy;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;

public class WelcomeActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		Handler handler = new Handler();
		//当计时结束,跳转至主界面
		handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
					startActivity(intent);
					WelcomeActivity.this.finish();
				}
			}, 5000);
	}
}
