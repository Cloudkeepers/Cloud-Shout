package com.cloudshout;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class AddItemActivity extends Activity {
	private String type = null;
	private TextView name, height, width, position, layer, show, stop;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.add_item);
    	name = (TextView)findViewById(R.id.editName);
    	height = (TextView)findViewById(R.id.editHeight);
    	width = (TextView)findViewById(R.id.editWidth);
    	position = (TextView)findViewById(R.id.editPosition);
    	layer = (TextView)findViewById(R.id.editLayer);
    	show = (TextView)findViewById(R.id.editShowTime);
    	stop = (TextView)findViewById(R.id.editStopTime);
	    
	    Bundle bundel = getIntent().getExtras(); 
	    try{
	        type = (String) bundel.get("type");
	        if(type.equalsIgnoreCase("text")){
	        	name.setText("TEXT OBJ");
	        	//TODO hide preview cols
	        }else if(type.equalsIgnoreCase("image")){
	        	name.setText("IMAGE OBJ");
	        }else if(type.equalsIgnoreCase("audio")){
	        	name.setText("AUDIO OBJ");
	        }else if(type.equalsIgnoreCase("video")){
	        	name.setText("VIDEO OBJ");
	        } else{
	        	throw new Exception("referanced type does not exists.");
	        }
	    }catch(Exception e){
	    	//TODO show error, then make new intent, or go back
	    }
	}
}

