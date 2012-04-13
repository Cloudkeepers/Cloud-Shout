package com.cloudshout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class SMILPlayer extends Activity {

	private RelativeLayout root;
	private int counter = 0;
	private List<SMILMedia> mediaList;
	private CountDownTimer timer;
	private ProgressBar pbar;
	
	public void OnCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		root = new RelativeLayout(this);
		
		mediaList = new ArrayList<SMILMedia>();
		
		Intent receive = getIntent();
		Bundle extras = receive.getExtras();
		Serializable test = extras.getSerializable("SMILObjects");
		
		if(test instanceof SerializeSO) {
			mediaList = ((SerializeSO)test).getList();
			setMediaList(mediaList);
		}
		
		if(mediaList.isEmpty() ) {
			Toast empty = Toast.makeText(this.getBaseContext(), "No Message", 5000);
			empty.show();
		}
		
		setContentView(root);
	}
	
	public void setMediaList(List<SMILMedia> mediaList) {
		this.mediaList = mediaList;
		loadMediaList();
	}
	
	private void loadMediaList() {
		for (SMILMedia media : this.mediaList){
			if(media instanceof Text){
				root.addView(((SMILVisual) media).createView(this), 
						new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
								RelativeLayout.LayoutParams.WRAP_CONTENT));
			}
			else if(media instanceof Image) {
				SMILVisual visual = (SMILVisual) media;
				root.addView(visual.createView(this), new RelativeLayout.LayoutParams(visual.getRight(), visual.getBottom()));
			}
			else {
				SMILVisual visual = (SMILVisual) media;
				root.addView(visual.createView(this), new RelativeLayout.LayoutParams(visual.getRight(), visual.getBottom()));
			}
		}
	}	
	
	private int getLength(List<SMILMedia> mediaList) {
		int length = 0;
		
		for(SMILMedia smilMedia : mediaList) {
			if (length <= smilMedia.getEnd()){
				length = smilMedia.getEnd();
			}
		}
		
		return length;
	}
	
	private void setUpProgressBar() {
		pbar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		
		root.addView(pbar, layoutParams);
		pbar.setPadding(0,  485, 0, 0);
		pbar.setMax(getLength(mediaList));
	}
	
	private void playMessage(int length, int cntr) {
		setUpProgressBar();
		pbar.setVisibility(View.VISIBLE);
		timer = new CountDownTimer(((long)(length - cntr + 1) * 1000), 1000){
			public void onTick(long mUF) {
				pbar.setProgress(counter);
				beginEnd(counter);
				counter++;
			}
			
			public void onFinish() {
				pbar.setProgress(counter);
				stopMessage();
			}
			
		};
		
		timer.start();
	}
	
	private void pauseMessage() {
		timer.cancel();
		for(SMILMedia smilMedia : mediaList) {
			smilMedia.pauseSO();
		}
		// mDialog lines commented out until I double check design with team
		// these will probably be replaced with Android buttons
		//mDialog("Paused:", "Resume", "Close", 4);
	}
	
	private void resumeMessage() {
		for(SMILMedia smilMedia : mediaList) {
			smilMedia.resumeSO();
		}
		
		playMessage(getLength(mediaList), counter);
	}
	
	private void stopMessage() {
		counter = 0;
		for(SMILMedia smilMedia : mediaList) {
			smilMedia.endSO();
		}
		// mDialog lines commented out until I double check design with team
		// these will probably be replaced with Android buttons
		//mDialog("Message Stopped:", "Replay", "Close", 4);
	}
	
	private void beginEnd(int counter) {
		for(SMILMedia smilMedia : mediaList) {
			if(counter == smilMedia.getBegin()){
				smilMedia.startSO();
			}
			if(counter == smilMedia.getEnd()){
				smilMedia.endSO();
			}
		}
	}
}