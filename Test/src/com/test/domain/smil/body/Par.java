package com.test.domain.smil.body;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Par {
	@XmlElement(name="img")
	private List<Img> images;
	
	@XmlElement(name="audio")
	private List<Audio> audio;
}