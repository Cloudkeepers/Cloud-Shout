package com.cloudshout.domain.smil.ref;

import com.cloudshout.domain.smil.SMILVisual;
import java.io.File;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

public class Image extends SMILVisual {
	
	private ImageView i;
	private Bitmap bitMap;
	
	// constructors
	public Image() {
		
	}
	
	public Image(String resource, int left, int top, int right, int bottom, int begin, int end) {
		this.setBegin(begin);
		this.setEnd(end);
		this.setLeft(left);
		this.setRight(right);
		this.setTop(top);
		this.setBottom(bottom);
		this.setResource(resource);		
	}
	
	public void startSO() {
		this.i.setVisibility(View.VISIBLE);
	}
	
	public void endSO() {
		this.i.setVisibility(View.INVISIBLE);
	}
	
	public void pauseSO() {
		
	}
	
	public void resumeSO() {
		
		
	}
	
	public View createView(Context c) {
		this.convertImageRes();
		this.i = new ImageView(c);
		this.i.setImageBitmap(bitMap);
		this.i.setScaleType(ImageView.ScaleType.FIT_XY);
		this.i.setPadding(getLeft(), getTop(), 0, 0);
		this.i.setVisibility(View.INVISIBLE);
		return this.i;
	}
	
	public View getView() {
		return this.i;
	}
	
	private void convertImageRes() {
		File imgFile = new File(this.getResource() );
		if(imgFile.exists() ) {
			bitMap = BitmapFactory.decodeFile(this.getResource() );
		}
	}
}
