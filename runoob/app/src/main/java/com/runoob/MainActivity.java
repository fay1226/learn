package com.runoob;

import android.app.*;
import android.os.*;
import android.webkit.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.net.*;
import android.graphics.*;
import junit.runner.*;
import android.annotation.*;

public class MainActivity extends Activity 
{
    WebView web;
	@SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.main);
		web = (WebView) findViewById(R.id.web);
		web.setVerticalScrollBarEnabled(false);
		web.setHorizontalScrollBarEnabled(false);
		web.setWebViewClient(new WebViewClient());
		WebSettings webSettings=web.getSettings();
		webSettings.setDefaultTextEncodingName("UTF-8");
		webSettings.setJavaScriptEnabled(true);
		webSettings.setBlockNetworkImage(false);
		String path="file:///android_asset/";
		webSettings.setDatabasePath(path);//设置数据库缓存路径
		webSettings.setAppCacheEnabled(true);//设置开启application H5 Caches 功能
		webSettings.setAppCachePath(path);//设置application caches 缓存目录
		//设置为优先本地加载模式
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		//支持H5
		webSettings.setDomStorageEnabled(true);
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) 
			webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setBuiltInZoomControls(false);
		web.loadUrl("https://m.runoob.com");
    }

	long exitTime=System.currentTimeMillis();
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK && web.canGoBack())
		{
			web.goBack();
		}
		else
		{
			if ((System.currentTimeMillis() - exitTime) > 2000)
			{
				Toast.makeText(getApplicationContext(), "再按人家就要离开啦", Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			}
			else
			{
				finish();
				System.exit(0);
			}
			return true;
		}
		return false;
    }
}
