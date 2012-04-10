package com.appspot.ckdgcloudshout;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class DownloadTest {
	public static void main(String[] args) {
		try {
			HttpResponse response = new DefaultHttpClient().execute(new HttpGet("http://localhost:8888/downloadmedia"));
			response.getStatusLine().getStatusCode();
			response.getAllHeaders();
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
