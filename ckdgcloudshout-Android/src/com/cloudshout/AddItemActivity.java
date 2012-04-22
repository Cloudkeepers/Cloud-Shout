package com.cloudshout;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class AddItemActivity extends Activity {
	private String type = null;
	private String coordinates = null;
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
	        coordinates = (String) bundel.get("coordinates");
	        
	        if(type.equalsIgnoreCase("text")){
	        	//TODO hide some cols
	        	updateProfile();
	        }else if(type.equalsIgnoreCase("image") ||
	        		type.equalsIgnoreCase("audio") || type.equalsIgnoreCase("video")){
	        	//TODO hide some cols
	        	updateProfile();
	        } else{
	        	throw new Exception("referanced type does not exists.");
	        }
	    }catch(Exception e){
	    	//TODO show error, then make new intent, or go back
	    }
	}
	
	private void updateProfile(){
		name.setText(type.toUpperCase());
		position.setText(coordinates.toString());
		//TODO complete update profile on a editText change
	}
	

	
}
