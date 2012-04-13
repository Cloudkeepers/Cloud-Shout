package com.test.domain.smil.head;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Layout {
	@XmlElement(name="root-layout")
	private RootLayout rootLayout;
	
	@XmlElement(name="region")
	private List<Region> regions;
}