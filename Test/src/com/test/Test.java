package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Test {
	public static void main(String[] args) {
		HttpClient urlClient = new DefaultHttpClient();
		HttpClient uploadClient = new DefaultHttpClient();
		try {
			HttpPost urlPost = new HttpPost("http://localhost:8888/retrieveurl");
			HttpResponse urlResponse = urlClient.execute(urlPost);
			String uploadUrl = urlResponse.getHeaders("uploadUrl")[0].getValue();
			
			HttpPost filePost = new HttpPost(uploadUrl);
			MultipartEntity httpEntity = new MultipartEntity();
			ContentBody contentBody = new FileBody(new File("resc/IMG_1164.JPG"));
			httpEntity.addPart("fileKey", contentBody);
			filePost.setEntity(httpEntity);
			HttpResponse uploadResponse = uploadClient.execute(filePost);
			String key = readStreamAsString(uploadResponse.getEntity().getContent());
			
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("blob-key", key));
			String query = "?" + URLEncodedUtils.format(params, "utf-8");
			HttpGet get = new HttpGet("http://localhost:8888/downloadmedia" + query);
			
			HttpResponse response = new DefaultHttpClient().execute(get);
			InputStream stream = response.getEntity().getContent();
			readStreamAsFile(stream);
			
			
			response.getStatusLine().getStatusCode();
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		Header[] headers = httpResponse.getHeaders(arg0)
//		for (int i = 0; i < headers.length; i++) {
//		Header header = headers[i];
//		if(header.getName().equals(myHeader))
//		uploadUrl = header.getValue();
		
		
//		HttpClient client = new DefaultHttpClient();
//		HttpPost post = new HttpPost("http://localhost:8888/test");
//		post.setHeader("Content-Type", "multipart/form-data; boundary=randomBoundaryNotInAnyOfParts");
//		
//		File file = new File("resc/IMG_0820.JPG");
//		FileBody fileBody = new FileBody(file);
////		FileInputStream stream;
//		try {
//			
//			MultipartEntity reqEntity = new MultipartEntity();
//			reqEntity.addPart("image", new FileBody(file));
//			post.setEntity(reqEntity);
//			
//			HttpResponse response = client.execute(post);
//			if (200 == response.getStatusLine().getStatusCode()) {
//				String contents = readStreamAsString(response.getEntity().getContent());
//			}
//			
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch (ClientProtocolException e) {
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
    }
	
	private static String readStreamAsString(InputStream in) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
			byte[] buffer = new byte[1024];
			int count;
			do {
				count = in.read(buffer);
				if (count > 0) {
					out.write(buffer, 0, count);
				}
			} while (count >= 0);
			
			return out.toString("UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException("The JVM does not support the compiler's default encoding.", e);
		}
		catch (IOException e) {
			return null;
		} 
		finally {
			try {
				in.close();
			}
			catch (IOException ignored) {
			}
		}
	}
	
	private static File readStreamAsFile(InputStream in) {
		try {
			File file = new File("resc/temp.jpeg");
			FileOutputStream out = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int count;
			do {
				count = in.read(buffer);
				if (count > 0) {
					out.write(buffer, 0, count);
				}
			} while (count >= 0);
			out.flush();
			out.close();
			
			return file;
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException("The JVM does not support the compiler's default encoding.", e);
		}
		catch (IOException e) {
			return null;
		} 
		finally {
			try {
				in.close();
			}
			catch (IOException ignored) {
			}
		}
	}
}
