package com.test.domain.smil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.test.domain.smil.body.Body;
import com.test.domain.smil.head.Head;

@XmlRootElement(name="smil")
public class Smil {
	@XmlElement(name="head")
	private Head head;
	
	@XmlElement(name="body")
	private Body body;
	
	public void setHead(Head head) {
		this.head = head;
	}
	
	public void setBody(Body body) {
		this.body = body;
	}
}