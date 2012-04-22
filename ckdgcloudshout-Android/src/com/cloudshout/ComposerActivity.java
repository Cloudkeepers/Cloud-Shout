package com.cloudshout;


import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class ComposerActivity extends Activity{
	
	//src:http://stackoverflow.com/questions/2939332/get-the-co-ordinates-of-a-touch-event-on-android
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.composer);
	    
	    final TextView textView = (TextView)findViewById(R.id.instructions);
	    final View touchView = findViewById(R.id.touchView);
	    
	    touchView.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
	            textView.setText("Touch coordinates : " +
	            		String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
		        return true;
			}
	    });
	}

}
