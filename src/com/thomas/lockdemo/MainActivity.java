package com.thomas.lockdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Activity nowActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		nowActivity = MainActivity.this;
		
		findViewById(R.id.btn_lock_screen).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(nowActivity, MyService.class);
				i.setAction(MyService.LOCK_ACTION);
				startService(i);
//				Toast.makeText(nowActivity, "", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

}
