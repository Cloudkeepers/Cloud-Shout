package com.cloudshout.domain.smil.ref;


//defines generic media reference
public abstract class Ref {
	private String key;		//Blobstore key
	private String layout;
	private String src;
	private int start;
	private int end;
}