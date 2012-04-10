package com.cloudshout.domain.smil.ref;

import com.cloudshout.domain.smil.SMILMedia;
import java.io.IOException;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class Audio extends SMILMedia implements OnCompletionListener {
	
	private MediaPlayer mp;
	private Boolean complete = false; // true = end of audio
	
	// constructors
	public Audio() {
		
	}
	
	public Audio(String resource, int begin, int end) {
		this.setBegin(begin);
		this.setEnd(end);
		this.setResource(resource);
	}
	
	public void startSO() {
		complete = false;
		mp = new MediaPlayer();
		mp.setOnCompletionListener(this);
		
		try {
			mp.setDataSource(this.getResource() );
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mp.start();
		
	}
	
	public void endSO() {
		mp.stop();
		complete = true;
	}
	
	public void pauseSO() {
		if(!complete) {
			mp.pause();
		}
	}
	
	public void resumeSO() {
		if(!complete) {
			mp.start();
		}
	}
	
	public void onCompletion(MediaPlayer arg0) {
		complete = true;
	}

}