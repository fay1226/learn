package pjz.cnm;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.WindowManager.*;
import android.widget.*;
import android.content.*;

public class w extends Activity
{
    /** Called when the activity is first created. */
	public native void a(String s);
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Intent intt=new Intent(w.this, s.class);
		this.startService(intt);
	}
}

