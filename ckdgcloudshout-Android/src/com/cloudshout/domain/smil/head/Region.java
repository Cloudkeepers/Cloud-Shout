package com.cloudshout.domain.smil.head;

import javax.xml.bind.annotation.XmlAttribute;

public class Region {
	@XmlAttribute(name="id")
	String id;
	
	@XmlAttribute(name="top")
	int top;
	
	@XmlAttribute(name="left")
	int left;
}