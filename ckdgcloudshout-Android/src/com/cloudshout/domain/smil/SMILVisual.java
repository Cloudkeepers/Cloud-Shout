package com.cloudshout.domain.smil;

import com.cloudshout.domain.smil.SMILMedia;
import android.content.Context;
import android.view.View;

public abstract class SMILVisual extends SMILMedia {
	
	public abstract View createView(Context c);
	public abstract View getView();
	
}
