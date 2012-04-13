package com.cloudshout.domain.smil;

import com.cloudshout.domain.smil.SMILMedia;
import android.content.Context;
import android.view.View;

public abstract class SMILVisual extends SMILMedia {
	private static final long serialVersionUID = 7128732977201531400L;
	public abstract View createView(Context c);
	public abstract View getView();
}