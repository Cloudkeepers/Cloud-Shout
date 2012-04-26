package com.cloudshout;

import com.cloudshout.Text;
import com.cloudshout.SMILMedia;
import com.cloudshout.domain.smil.*;
import com.cloudshout.domain.smil.body.*;
import com.cloudshout.domain.smil.head.*;
import java.util.*;
import java.lang.System;

public class TempPlayerTest {
	
	
	
	public static void main(String[] args) {
		
		// build text for message
		String resource1 = "Hello world!";
		int left1 = 0;
		int right1 = 0;
		int begin1 = 0;
		int end1 = 5;
		
		String resource2 = "This is a test of the Cloudshout Player";
		int left2 = 10;
		int right2 = 10;
		int begin2 = 5;
		int end2 = 10;
		
		Text text1 = new Text(resource1, left1, right1, begin1, end1);
		Text text2 = new Text(resource2, left2, right2, begin2, end2);
		
		// wrap Text objects in array list
		ArrayList<SMILMedia> mediaList = new ArrayList<SMILMedia>();
		mediaList.add(text1);
		mediaList.add(text2);
		
		// construct head
		
		// construct body
		
		// build Smil object
		
	}
}
