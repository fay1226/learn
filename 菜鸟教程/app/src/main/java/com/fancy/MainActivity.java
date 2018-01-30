package com.fancy;

import android.app.*;
import android.os.*;
import android.webkit.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		web=(WebView) findViewById(R.id.web);
		web.setVerticalScrollBarEnabled(false);
		web.setHorizontalScrollBarEnabled(false);
		WebSettings webSettings=web.getSettings();
		web.setWebViewClient(new WebViewClient());
		webSettings.setDefaultTextEncodingName("UTF-8");
		webSettings.setJavaScriptEnabled(true);
		webSettings.setBlockNetworkImage(true);
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setBuiltInZoomControls(false);
		web.loadUrl("https://m.runoob.com");
    }
	
	long exitTime=System.currentTimeMillis();
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			if((System.currentTimeMillis()-exitTime)>2000){
				Toast.makeText(getApplicationContext(),"再按一次退出",Toast.LENGTH_SHORT).show();
				exitTime=System.currentTimeMillis();
			}else{
				finish();
				System.exit(0);
			}
			return true;
		}
		return false;
    }
}
