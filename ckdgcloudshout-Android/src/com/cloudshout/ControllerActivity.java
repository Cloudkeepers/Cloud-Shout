package com.cloudshout;

import java.util.ArrayList;
import java.util.List;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import com.cloudshout.R;


public class ControllerActivity extends TabActivity implements OnTabChangeListener {
	private static final String LIST1_TAB_TAG = "Inbox";
	private static final String LIST2_TAB_TAG = "Outbox";
	private static final String LIST3_TAB_TAG = "Drafts";
	private static final String LIST4_TAB_TAG = "New";
	private TabHost tabHost;
	private ListView inboxListView;
	private List<Object> inbox = new ArrayList<Object>();
	private ListView outboxListView;
	private List<Object> outbox = new ArrayList<Object>();
	private ListView draftsListView;
	private List<Object> drafts = new ArrayList<Object>();
	private LinearLayout composeLinearLayout;
    public Intent myIntent;
    
    /**
     * Create's Android menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.controller_menu, menu);
        return true;
    }
    
    /**
     * Is called once menu item is selected from the android menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.newMessage:
            	//launch composer
				myIntent = new Intent(ControllerActivity.this, ComposerActivity.class);
			    ControllerActivity.this.startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controller);
        
        
        Resources res = getResources(); // Resource object to get Drawables
		tabHost = getTabHost();
		tabHost.setOnTabChangedListener(this);
		inboxListView = (ListView) findViewById(R.id.inbox);
		outboxListView = (ListView) findViewById(R.id.outbox);
		draftsListView = (ListView) findViewById(R.id.drafts);
		composeLinearLayout = (LinearLayout) findViewById(R.id.compose);

		
		tabHost.addTab(tabHost.newTabSpec(LIST1_TAB_TAG).setIndicator(LIST1_TAB_TAG, res.getDrawable(R.drawable.ic_tab_inbox)).setContent(new TabContentFactory() {
			public View createTabContent(String arg0) {
				return inboxListView;
			}
		}));
		tabHost.addTab(tabHost.newTabSpec(LIST2_TAB_TAG.toLowerCase()).setIndicator(LIST2_TAB_TAG, res.getDrawable(R.drawable.ic_tab_outbox)).setContent(new TabContentFactory() {
			public View createTabContent(String arg0) {
				return outboxListView;
			}
		}));
		tabHost.addTab(tabHost.newTabSpec(LIST3_TAB_TAG.toLowerCase()).setIndicator(LIST3_TAB_TAG, res.getDrawable(R.drawable.ic_tab_drafts)).setContent(new TabContentFactory() {
			public View createTabContent(String arg0) {
				return draftsListView;
			}
		}));
		tabHost.addTab(tabHost.newTabSpec(LIST4_TAB_TAG.toLowerCase()).setIndicator(LIST4_TAB_TAG, res.getDrawable(R.drawable.ic_menu_compose)).setContent(new TabContentFactory() {
			public View createTabContent(String tag) {
				return composeLinearLayout;
			}
		}));
    }
    
    
	/**
	 * Implement logic here when a tab is selected
	 */
	public void onTabChanged(String tabName) {
		inbox = new ArrayList<Object>();
		outbox = new ArrayList<Object>();
		drafts = new ArrayList<Object>();
		
		
		if(tabName.equalsIgnoreCase(LIST1_TAB_TAG)) {
			inbox.add("Person 1");
			inbox.add("Person 2");
			inbox.add("Person 3");
			inbox.add("Person 4");
			inbox.add("Person 5");
			inbox.add("Person 6");
			inbox.add("Person 7");
			
			//TODO get inbox data here
		}
		else if(tabName.equalsIgnoreCase(LIST2_TAB_TAG)) {
			outbox.add("Person A");
			outbox.add("Person B");
			outbox.add("Person C");
			outbox.add("Person D");
			outbox.add("Person E");
			
			//TODO get outbox data here
		}
		else if(tabName.equalsIgnoreCase(LIST3_TAB_TAG)) {
			//will try to by this week, this month, a couple of months, and older.
			drafts.add("Monday");
			drafts.add("Thursday");
			drafts.add("2 Weeks Old");
			drafts.add("3 Weeks Old");
			drafts.add("2 Months Old");
			drafts.add("4 Months Old");
			drafts.add("6+ Months Old");
			
			//TODO get drafts data here
		}
		else if(tabName.equalsIgnoreCase(LIST4_TAB_TAG)) {
        	//launch composer
			tabHost.setCurrentTab(0);
			//myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			//myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			myIntent = new Intent(ControllerActivity.this, ComposerActivity.class);
		    ControllerActivity.this.startActivity(myIntent);
		}
		
		
		inboxListView.setAdapter(new ArrayAdapter(this, R.layout.controller_item, inbox));
		outboxListView.setAdapter(new ArrayAdapter(this, R.layout.controller_item, outbox));
		draftsListView.setAdapter(new ArrayAdapter(this, R.layout.controller_item, drafts));
		
		//Add an onclicklisteners for inbox, outbox, and drafted items
		inboxListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view, int position, long id) {
				String item = (String) inboxListView.getAdapter().getItem(position);
				
				//Inbox items will be grouped by the "recieved from" contact
				myIntent = new Intent(ControllerActivity.this, FilteredControllerActivity.class);
				myIntent.putExtra("type","inbox");
			    myIntent.putExtra("source",item);
			    ControllerActivity.this.startActivity(myIntent);
			}
		});
		outboxListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view, int position, long id) {
				String item = (String) outboxListView.getAdapter().getItem(position);
				
				//Outbox items will grouped by the "sent to" contact
				myIntent = new Intent(ControllerActivity.this, FilteredControllerActivity.class);
				myIntent.putExtra("type","outbox");
			    myIntent.putExtra("source",item);
			    ControllerActivity.this.startActivity(myIntent);
			}
		});
		draftsListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view, int position, long id) {
				String item = (String) draftsListView.getAdapter().getItem(position);
				
				//Drafts will be grouped by its age/ date composed.
				myIntent = new Intent(ControllerActivity.this, FilteredControllerActivity.class);
				myIntent.putExtra("type","drafts");
			    myIntent.putExtra("source",item);
			    ControllerActivity.this.startActivity(myIntent);
			}
		});
	}
}