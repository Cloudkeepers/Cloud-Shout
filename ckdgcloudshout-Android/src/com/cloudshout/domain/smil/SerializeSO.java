package com.cloudshout.domain.smil;

import java.io.Serializable;
import java.util.ArrayList;
import com.cloudshout.domain.smil.SMILMedia;

public class SerializeSO implements Serializable {
	
	private ArrayList<SMILMedia> SMILlist = null;
	
	public SerializeSO(ArrayList<SMILMedia> SMILlist) {
		this.SMILlist = SMILlist;
	}
	
	public ArrayList<SMILMedia> getList() {
		return this.SMILlist;
	}

}
