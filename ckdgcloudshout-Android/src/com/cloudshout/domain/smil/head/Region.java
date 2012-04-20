package com.cloudshout.domain.smil.head;

import javax.xml.bind.annotation.XmlAttribute;

public class Region {
	@XmlAttribute(name="id")
	private String id;
	
	@XmlAttribute(name="bottom")
	private int bottom;

	@XmlAttribute(name="left")
	private int left;

	@XmlAttribute(name="right")
	private int right;
	
	@XmlAttribute(name="height")
	private int height;
	
	@XmlAttribute(name="width")
	private int width;
}