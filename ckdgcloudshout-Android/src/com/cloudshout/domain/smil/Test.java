package com.cloudshout.domain.smil;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Test {
	public static void main(String[] args) {
		Head head = new Head();
		head.setId("testID");
		head.setTitle("testTitle");
		
		System.out.println("Derr");

//		try {
//			File file = new File("res/file.xml");
//			JAXBContext context = JAXBContext.newInstance(Head.class);
//			Marshaller marshaller = context.createMarshaller();
//			
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			marshaller.marshal(head, file);
//			marshaller.marshal(head, System.out);
//			
//		}
//		catch (JAXBException e) {
//			e.printStackTrace();
//		}
	}
}