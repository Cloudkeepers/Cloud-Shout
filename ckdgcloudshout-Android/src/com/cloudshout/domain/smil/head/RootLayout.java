package com.cloudshout.domain.smil.head;

import javax.xml.bind.annotation.XmlAttribute;

public class RootLayout {
	@XmlAttribute(name="width")
	private int width;
	
	@XmlAttribute(name="height")
	private int height;
}