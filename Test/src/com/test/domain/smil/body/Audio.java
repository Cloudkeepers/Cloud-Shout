package com.test.domain.smil.body;

import javax.xml.bind.annotation.XmlAttribute;

public class Audio extends SMILMedia {
	@XmlAttribute(name="src")
	String src;
	
	@XmlAttribute(name="region")
	String region;
	
	@XmlAttribute(name="begin")
	String begin;
	
	@XmlAttribute(name="end")
	String end;
	
	@XmlAttribute(name="dur")
	String duration;
}