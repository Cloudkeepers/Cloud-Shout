package com.test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Head extends AbstractSMIL {
	private String id;
	private String title;
	
	public String getId() {
		return id;
	}
	
	@XmlAttribute(name="id")
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	@XmlAttribute(name="title")
	public void setTitle(String title) {
		this.title = title;
	}
}