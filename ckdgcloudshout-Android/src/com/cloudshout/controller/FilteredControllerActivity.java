package com.cloudshout.controller;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudshout.R;

public class FilteredControllerActivity extends Activity {
	
	private ListView contentsListView;
	private List<Object> contents = new ArrayList<Object>();
	private TextView label;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_controller);
        
        
        contentsListView = (ListView) findViewById(R.id.content);
        label = (TextView) findViewById(R.id.label);
        

		String type = null;
		Object source = null;
		Bundle bundel = getIntent().getExtras(); 
		
		try{  
            type = (String) bundel.get("type");  
            source = (Object) bundel.get("source");  
        }catch(Exception e){
    	}  

        
        
		label.setText(type.toUpperCase() + " from " + source.toString().toUpperCase());
		
		//load messages here
		contents = new ArrayList<Object>();
		
		int total = (int) (Math.random()*15);
		
		if(type.equalsIgnoreCase("drafts")){
			for (int i = 0; i < total; i++){
				contents.add("Draft " + i);
			}
		} else {
			int year, month, day, hour, min;
			String dayNight;
			for (int i = 0; i < total; i++){
				year = (int)((Math.random()* 10 ) * (i+1)/total) + 2000;
				month = (int)((Math.random()* 11 ) * (i+1)/total) + 1;
				day = (int)((Math.random()* 29 ) * (i+1)/total) + 0;
				hour = (int)(Math.random()* 23 ) + 0;
				if(hour >= 12){
					dayNight = "PM";
				} else{
					dayNight = "AM";
				}
				min = (int)(Math.random()* 59 ) + 1;
				
				contents.add(year + "/" + month + "/" + day + " " + hour + ":" + min + " " + dayNight + " EST");
			}			
		}
		
		
		
		//dynamic stuff here
		contentsListView.setAdapter(new ArrayAdapter(this, R.layout.controller_item, contents));
		//Add an onclicklisteners for messages
		contentsListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view, int position, long id) {
				String item = (String) contentsListView.getAdapter().getItem(position);
				Toast.makeText(FilteredControllerActivity.this, "Open: " + item + ".", Toast.LENGTH_SHORT).show();
				
				/*Inbox items will be grouped by the "recieved from" contact
				myIntent = new Intent(ControllerActivity.this, FilteredControllerActivity.class);
				myIntent.putExtra("type","inbox");
			    myIntent.putExtra("source",item);
			    ControllerActivity.this.startActivity(myIntent);
			    */
				
			}
		});
    }
}
