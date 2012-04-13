package com.cloudshout.domain.smil;

import java.io.Serializable;
import java.util.List;

public class SerializeSO implements Serializable {
	private static final long serialVersionUID = -5156229858520238614L;
	private List<SMILMedia> SMILlist = null;
	
	public SerializeSO(List<SMILMedia> SMILlist) {
		this.SMILlist = SMILlist;
	}
	
	public List<SMILMedia> getList() {
		return this.SMILlist;
	}
}