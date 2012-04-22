package com.cloudshout;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ComposerActivity extends Activity{
	Map smilObjects = new HashMap<Integer, Object>();
	int objectsCounter = 0;
	
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
        Intent myIntent;
		// Handle item selection
        switch (item.getItemId()) {
        	case R.id.composer_cancle:
        		//propt exit alert
        		DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        		    public void onClick(DialogInterface dialog, int which) {
        		        switch (which){
        		        case DialogInterface.BUTTON_POSITIVE:
        		            //No button clicked
        		        	//do nothing
        		            break;
        		        case DialogInterface.BUTTON_NEGATIVE:
        		            //Yes button clicked
        	        		//return to ControllerActivity
        		        	Intent myIntent;
        		        	myIntent = new Intent(ComposerActivity.this, ControllerActivity.class);
        	    			myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
        	    			myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	    			ComposerActivity.this.startActivity(myIntent);
        		        }
        		    }
        		};
        		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        		builder.setMessage("Are you sure you want to exit?  All data will be lost.").setPositiveButton("No", dialogClickListener)
        		    .setNegativeButton("Yes", dialogClickListener).show();
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
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.composer);
	    
	    final TextView textView = (TextView)findViewById(R.id.instructions);
	    final View touchView = findViewById(R.id.touchView);
	    
	    touchView.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, final MotionEvent event) {				
				final CharSequence[] items = {"Text", "Image", "Audio", "Video"};

				AlertDialog.Builder builder = new AlertDialog.Builder(ComposerActivity.this);
				builder.setTitle("Select an item to add.");
				builder.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				    	
						//TODO Call parser here, get SMIL objects back
				    	
				    	if(items[item].toString().equalsIgnoreCase("Text") || 
			    			items[item].toString().equalsIgnoreCase("Image") ||
			    			items[item].toString().equalsIgnoreCase("Audio") ||
			    			items[item].toString().equalsIgnoreCase("Video")){
			    			Intent myIntent = new Intent(ComposerActivity.this, AddItemActivity.class);
				    		myIntent.putExtra("type",items[item].toString());
				    		myIntent.putExtra("coordinates",String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
				    		ComposerActivity.this.startActivity(myIntent);
				    	} else{
				    		//do nothing, however
				    	}
				    	
				    }
				});
				AlertDialog alert = builder.create();
				alert.show();
		        return true;
			}
	    });
	}

}
