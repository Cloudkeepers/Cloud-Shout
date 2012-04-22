package com.cloudshout;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class ComposerActivity extends Activity{
	
	
    /**
     * Create's Android menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.composer_menu, menu);
        return true;
    }
    
    
    /**
     * Is called once menu item is selected from the android menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        	case R.id.composer_cancle:
        		//TODO composer onCancel stuff
        		return true;
        	case R.id.composer_save:
            	//TODO composer onSave stuff
                return true;
            case R.id.composer_send:
            	//TODO composer onSend stuff
            	return true;
            case R.id.composer_preview:
            	//TODO composer onPreview stuff
            	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
	
    
    /**
     * Is called by the android OS.  Required.
     */
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
