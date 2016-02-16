package com.thomas.lockdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;


public class ScreenSaverView extends RelativeLayout
{
	private Context mContext;
	private View rootView;
	
	private Button btnUnlock;
	
	public ScreenSaverView(Context context)
	{
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rootView = inflater.inflate(R.layout.screen_saver, this);
		btnUnlock = (Button) rootView.findViewById(R.id.btn_unlock_screen);
		
		if(btnUnlock != null)
			System.out.println("found the button");
		btnUnlock.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(mContext, MyService.class);
				i.setAction(MyService.UNLOCK_ACTION);
				mContext.startService(i);
			}
		});
	}
	
	
}
