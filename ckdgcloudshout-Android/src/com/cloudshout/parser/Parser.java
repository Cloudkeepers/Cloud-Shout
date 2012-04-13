package com.cloudshout.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cloudshout.domain.smil.Smil;

public class Parser {
	public static Smil unmarshal(File file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Smil.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		return (Smil) unmarshaller.unmarshal(file);
	}
	
	public static void marshal(Smil smil, File file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Smil.class);
		Marshaller marshaller = context.createMarshaller();
		
		marshaller.marshal(smil, file);
	}
}