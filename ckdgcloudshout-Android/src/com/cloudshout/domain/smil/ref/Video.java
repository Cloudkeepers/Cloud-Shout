package com.cloudshout.domain.smil.ref;

import com.cloudshout.domain.smil.SMILVisual;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class Video extends SMILVisual implements OnCompletionListener {
	
	private VideoView v;
	private RelativeLayout layout;
	private Boolean complete = false; // true = end of video
	
	public Video() {
		
	}
	
	public Video(String resource, int left, int top, int right, int bottom, int begin, int end) {
		this.setBegin(begin);
		this.setEnd(end);
		this.setLeft(left);
		this.setRight(right);
		this.setTop(top);
		this.setBottom(bottom);
		this.setResource(resource);		
	}
	
	public void startSO() {
		complete = false;
		this.layout.setVisibility(View.VISIBLE);
		v.start();
	}
	
	public void endSO() {
		v.pause();
		v.seekTo(0);
		this.layout.setVisibility(View.GONE);
		complete = true;
	}
	
	public void pauseSO() {
		if(!complete) {
			v.pause();
		}
	}
	
	public void resumeSO() {
		if(!complete) {
			v.start();
		}
	}
	
	public View createView(Context c) {
		v = new VideoView(c);
		v.setOnCompletionListener(this);
		v.setVideoPath(this.getResource() );
		this.layout = new RelativeLayout(c);
		this.layout.setPadding(getLeft(), getTop(), 0, 0);
		this.layout.addView(this.v, new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT) );
		this.layout.setVisibility(View.GONE);
		return layout;
	}
	
	public View getView() {
		return layout;
	}
	
	public void onCompletion(MediaPlayer arg0) {
		complete = true;
	}

}