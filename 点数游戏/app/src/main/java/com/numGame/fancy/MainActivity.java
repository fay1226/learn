package com.numGame.fancy;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.webkit.*;
import android.widget.*;
import android.content.*;
import android.media.*;
import android.graphics.*;

public class MainActivity extends Activity 
{
	private WebView webView;
	private long exitTime=0;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if(webView.canGoBack()&&keyCode==KeyEvent.KEYCODE_BACK){
			webView.goBack();
			return true;
		}
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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		webView = (WebView) findViewById(R.id.webview);
		//始终在本页面显示网页
		webView.setWebViewClient(new WebViewClient());
		//隐藏纵向滚动条
		webView.setVerticalScrollBarEnabled(false);
		//隐藏横向滚动条
		webView.setHorizontalScrollBarEnabled(false);
		WebSettings webSettings=webView.getSettings();
		//自适应屏幕
		webSettings.setLoadWithOverviewMode(true);
		//加载JavaScript
		webSettings.setJavaScriptEnabled(true);
		//支持H5
		webSettings.setDomStorageEnabled(true);
		//设置可以支持缩放
		webSettings.setSupportZoom(true);
		//扩大比例的缩放
		webSettings.setUseWideViewPort(true);
		//设置是否出现缩放工具
		webSettings.setBuiltInZoomControls(false);
        //找到Html文件，也可以用网络上的文件
		String file="file:///android_asset/numGame.html";
		//加载网页
		webView.loadUrl(file);
		//webView.loadDataWithBaseURL("file:///android_asset/",file,"text/html","utf-8",null);
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;//返回true,立即跳转,返回false,打开网页有延时
            }
			/*@Override
			public void onPageFinished(WebView view,String url){
				prog.dismiss();
			}*/
		});
	}
}
