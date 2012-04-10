package com.cloudshout.domain.smil.ref;

import com.cloudshout.domain.smil.SMILVisual;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class Text extends SMILVisual {
	
	private TextView t;
	
	// constructors
	public Text() {
		
	}
	
	public Text(String resource, int left, int top, int begin, int end){
		this.setBegin(begin);
		this.setEnd(end);
		this.setTop(top);
		this.setResource(resource);
	}
	
	public void startSO() {
		this.t.setVisibility(View.VISIBLE);
	}

	public void endSO() {
		this.t.setVisibility(View.INVISIBLE);
	}
	
	public void pauseSO() {
		
	}
	
	public void resumeSO() {
		
	}
	
	public View createView(Context c) {
		this.t = new TextView(c);
		this.t.setText(getResource() );
		this.t.setPadding(this.getLeft(), this.getTop(), 0, 0);
		this.t.setVisibility(View.INVISIBLE);
		return this.t;
	}
	
	public View getView() {
		return this.t;
	}
}