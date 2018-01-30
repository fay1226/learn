package com.pro.fancy;
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
	private Button reBack,reNext,music;
	//private ProgressDialog prog;
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
		reBack=(Button) findViewById(R.id.backBtn);
		reNext=(Button) findViewById(R.id.nextBtn);
		music=(Button) findViewById(R.id.music);
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
		//是否隐藏图片
		webSettings.setBlockNetworkImage(false);
		String path="file:///android_asset/";
		webSettings.setDatabasePath(path);//设置数据库缓存路径
		webSettings.setAppCacheEnabled(true);//设置开启application H5 Caches 功能
		webSettings.setAppCachePath(path);//设置application caches 缓存目录
		//设置为优先本地加载模式
		//webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		//支持H5
		webSettings.setDomStorageEnabled(true);
		//处理http与https协议图片不显示
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) 
			webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		//设置可以支持缩放
		webSettings.setSupportZoom(true);
		//扩大比例的缩放
		webSettings.setUseWideViewPort(true);
		//设置是否出现缩放工具
		webSettings.setBuiltInZoomControls(false);
        //找到Html文件，也可以用网络上的文件
		String file="file:///android_asset/chat.html";
		//加载网页
		//prog=ProgressDialog.show(this,null,"加载中……");
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
		//背景音乐
		final MediaPlayer mediaPlayer=MediaPlayer.create(this, R.raw.one);
		mediaPlayer.setLooping(true);
		mediaPlayer.start();
		music.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					if(mediaPlayer.isPlaying()){
						mediaPlayer.pause();
						music.setText("⦿");
					}else{
						mediaPlayer.start();
						music.setText("♡");
					}
				}
			});
		reBack.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					if(webView.canGoBack()){
						webView.loadUrl("javascript:history.go(-1)");
					}
				}
			});
		reNext.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					if(webView.canGoForward()){
						webView.goForward();
					}
				}
			});
	}
}
