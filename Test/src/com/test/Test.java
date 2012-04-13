package com.test;

import java.io.File;

import javax.xml.bind.JAXBException;

import com.test.domain.smil.Smil;

public class Test {
	public static void main(String[] args) {
		try {
			Smil smil = Parser.unmarshal(new File("resc/sample.smil"));
			System.out.print('d');
			
			Parser.marshal(smil, new File("out.smil"));
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}