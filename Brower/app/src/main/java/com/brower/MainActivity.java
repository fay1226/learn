package com.brower;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.webkit.*;
import android.graphics.*;
import android.view.*;
import java.util.regex.*;
import android.view.View.*;
import java.util.*;

public class MainActivity extends Activity 
{
	AutoCompleteTextView url;
	WebView show;

	String[] urlArr = new String[]
	{
		"https://www.baidu.com",
		"https://m.runoob.com",
		"https://ke.qq.com",
		"http://www.baidu.com",
		"http://qq.com",
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final Activity activity = this;
		Button refreshBtn = (Button)findViewById(R.id.refresh);

        show = (WebView)findViewById(R.id.show);
		//隐藏纵向滚动条
		show.setVerticalScrollBarEnabled(false);
		//隐藏横向滚动条
		show.setHorizontalScrollBarEnabled(false);
		WebSettings webSettings=show.getSettings();
        webSettings.setJavaScriptEnabled(true);
		webSettings.setBlockNetworkImage(false);
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
			webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		webSettings.setSupportZoom(true);
		webSettings.setLoadWithOverviewMode(true);
		//扩大比例的缩放
		webSettings.setUseWideViewPort(true);
		//设置是否出现缩放工具
		webSettings.setBuiltInZoomControls(false);
		show.loadUrl(urlArr[0]);
        show.setWebViewClient(new WebViewClient()
			{
				public boolean shouldOverrideUrlLoading(WebView view, String strUrl)
				{
					view.loadUrl(strUrl);
					url.setText(strUrl);
					return false;
				}

				public void onPageStarted(WebView view, String strUrl, Bitmap favicon)
				{
					super.onPageStarted(view, strUrl, favicon);
					url.setText(strUrl);
				}

				public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) 
				{
					show.loadUrl(urlArr[2]+"?word="+failingUrl);
					Toast.makeText(activity,description,Toast.LENGTH_SHORT).show();
				}
			});

        url = (AutoCompleteTextView)findViewById(R.id.url);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, urlArr);
        url.setAdapter(arrayAdapter);
        url.setOnKeyListener(new View.OnKeyListener() 
			{			
				public boolean onKey(View v, int keyCode, KeyEvent ev) 
				{
					if (keyCode == KeyEvent.KEYCODE_ENTER)
					{
						String strUrl = url.getText().toString();
						Pattern p = Pattern.compile("http://([\\w-]+\\.)+[\\w-]+(/[\\w-\\./?%=]*)?");
						Matcher m = p.matcher(strUrl);
						if (!m.find())
						{
							strUrl = "http://" + strUrl;
							show.loadUrl(strUrl);
							return true;
						}
					}
					return false;
				}
			});

        // button 
        final Button backBtn = (Button)findViewById(R.id.back);
        final Button forwardBtn = (Button)findViewById(R.id.forward);
        Button homeBtn = (Button)findViewById(R.id.home);
        backBtn.setEnabled(false);
        forwardBtn.setEnabled(false);

        backBtn.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					show.goBack();
				}
			});

        forwardBtn.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					show.goForward();
				}
			});

        refreshBtn.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					String strUrl = url.getText().toString();
					Pattern p = Pattern.compile("http://([\\w-]+\\.)+[\\w-]+(/[\\w-\\./?%=]*)?");
					Matcher m = p.matcher(strUrl);
					if (!m.find()) strUrl = "http://" + strUrl;
					show.loadUrl(strUrl);
				}
			});

        homeBtn.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					show.loadUrl(urlArr[0]);
				}
			});

        final Handler handler = new Handler()
        {
        	@Override
        	public void handleMessage(Message msg)
        	{
        		if (msg.what == 0x1111)
        		{
        			// whether can go back  
            		if (show.canGoBack())
            			backBtn.setEnabled(true);
            		else backBtn.setEnabled(false);

            		// whether can go forward
            		if (show.canGoForward())
            			forwardBtn.setEnabled(true);
            		else forwardBtn.setEnabled(false);
        		}
        		super.handleMessage(msg);
        	}
        };

        // create thread to change button states 
        new Timer().schedule(new TimerTask()
			{
				public void run()
				{
					Message msg = new Message();
					msg.what = 0x1111;
					handler.sendMessage(msg);
				}
			},0,100);
    }

	private long exitTime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
			if((System.currentTimeMillis()-exitTime)>2000){
				Toast.makeText(getApplicationContext(),"再按人家就要离开啦",Toast.LENGTH_SHORT).show();
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
