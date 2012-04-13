package com.cloudshout;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class SMILMedia implements Serializable {
	private static final long serialVersionUID = -4181974875361868285L;
	// values for timing, positioning, etc.
	private Integer begin = 0;
	private Integer end = 0;
	private String resource = " ";
	private Integer left = 0;
	private Integer top = 0;
	private Integer right = 0;
	private Integer bottom = 0;
	
	// path of media resource
	private String path = "";
	
	// abstract methods for SMILMedia Objects
	public abstract void startSO();
	public abstract void endSO();
	public abstract void pauseSO();
	public abstract void resumeSO();
	
	// getters & setters
	public Integer getBegin() {
		return begin;
	}
	
	@XmlAttribute
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
	public Integer getEnd() {
		return end;
	}
	
	@XmlAttribute
	public void setEnd(Integer end) {
		this.end = end;
	}
	
	public String getResource() {
		return resource;
	}
	
	@XmlAttribute
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public Integer getLeft() {
		return left;
	}
	
	@XmlAttribute
	public void setLeft(Integer left) {
		this.left = left;
	}
	
	public Integer getTop() {
		return top;
	}
	
	@XmlAttribute
	public void setTop(Integer top) {
		this.top = top;
	}
	
	public Integer getRight() {
		return right;
	}
	
	@XmlAttribute
	public void setRight(Integer right) {
		this.right = right;
	}
	
	public Integer getBottom() {
		return bottom;
	}
	
	@XmlAttribute
	public void setBottom(Integer bottom) {
		this.bottom = bottom;
	}
	
	public String getPath() {
		return path;
	}
	
	@XmlAttribute
	public void setPath(String path) {
		this.path = path;
	}
}