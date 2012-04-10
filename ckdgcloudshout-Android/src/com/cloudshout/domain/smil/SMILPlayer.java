package com.cloudshout.domain.smil;

import java.io.Serializable;
import java.util.ArrayList;

import com.cloudshout.domain.smil.ref.Image;
import com.cloudshout.domain.smil.ref.Text;
import com.cloudshout.domain.smil.SMILMedia;
import com.cloudshout.domain.smil.SMILVisual;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
//import android.view.GestureDetector;
//import android.view.GestureDetector.OnGestureListener;
//import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class SMILPlayer extends Activity {

	private RelativeLayout root;
	private int counter = 0;
	private ArrayList<SMILMedia> mediaList;
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
	
	public boolean setMediaList(ArrayList<SMILMedia> mediaList) {
		boolean returnValue = false;
		
		this.mediaList = mediaList;
		loadMediaList();
		returnValue = true;
		
		return returnValue;
	}
	
	private void loadMediaList() {
		for (SMILMedia media : this.mediaList){
			if(media instanceof Text){
				root.addView(((SMILVisual) media).createView(this), 
						new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
								RelativeLayout.LayoutParams.WRAP_CONTENT));
			}
			else if(media instanceof Image) {
				root.addView(((SMILVisual) media).createView(this),
						new RelativeLayout.LayoutParams(((SMILVisual) media).getRight(),
								((SMILVisual) media).getBottom()));
			}
			else {
				root.addView(((SMILVisual) media).createView(this),
						new RelativeLayout.LayoutParams(((SMILVisual) media).getRight(),
								((SMILVisual) media).getBottom()));
			}
		}
	}	
	
	private int getLength(ArrayList<SMILMedia> mediaList) {
		int length = 0;
		
		for (int i = 0; i < mediaList.size(); i++) {
			if (length <= mediaList.get(i).getEnd()){
				length = mediaList.get(i).getEnd();
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
		for(int i = 0; i < mediaList.size(); i++) {
			mediaList.get(i).pauseSO();
		}
		// mDialog lines commented out until I double check design with team
		// these will probably be replaced with Android buttons
		//mDialog("Paused:", "Resume", "Close", 4);
	}
	
	private void resumeMessage() {
		for(int i = 0; i < mediaList.size(); i++) {
			mediaList.get(i).resumeSO();
		}
		
		playMessage(getLength(mediaList), counter);
	}
	
	private void stopMessage() {
		counter = 0;
		for(int i = 0; i < mediaList.size(); i++) {
			mediaList.get(i).endSO();
		}
		// mDialog lines commented out until I double check design with team
		// these will probably be replaced with Android buttons
		//mDialog("Message Stopped:", "Replay", "Close", 4);
	}
	
	private void beginEnd(int counter) {
		for(int i = 0; i < mediaList.size(); i++) {
			if(counter == mediaList.get(i).getBegin()){
				mediaList.get(i).startSO();
			}
			if(counter == mediaList.get(i).getEnd()){
				mediaList.get(i).endSO();
			}
		}
	}
}













