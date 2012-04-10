package com.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Test {
	public static void main(String[] args) {
		
		Head head = new Head();
		head.setId("testID");
		head.setTitle("testTitle");
		
		try {
			File file = new File("resc/file.xml");
			JAXBContext context = JAXBContext.newInstance(Head.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(head, file);
			marshaller.marshal(head, System.out);
			
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
//		
//		HttpClient urlClient = new DefaultHttpClient();
//		HttpClient uploadClient = new DefaultHttpClient();
//		try {
//			HttpPost urlPost = new HttpPost("http://localhost:8888/retrieveurl");
//			HttpResponse urlResponse = urlClient.execute(urlPost);
//			String uploadUrl = urlResponse.getHeaders("uploadUrl")[0].getValue();
//			
//			HttpPost filePost = new HttpPost(uploadUrl);
//			MultipartEntity httpEntity = new MultipartEntity();
//			ContentBody contentBody = new FileBody(new File("resc/IMG_1164.JPG"));
//			httpEntity.addPart("fileKey", contentBody);
//			filePost.setEntity(httpEntity);
//			HttpResponse uploadResponse = uploadClient.execute(filePost);
//			String key = readStreamAsString(uploadResponse.getEntity().getContent());
//			
//			List<NameValuePair> params = new ArrayList<NameValuePair>();
//			params.add(new BasicNameValuePair("blob-key", key));
//			String query = "?" + URLEncodedUtils.format(params, "utf-8");
//			HttpGet get = new HttpGet("http://localhost:8888/downloadmedia" + query);
//			
//			HttpResponse response = new DefaultHttpClient().execute(get);
//			InputStream stream = response.getEntity().getContent();
//			readStreamAsFile(stream);
//			
//			
//			response.getStatusLine().getStatusCode();
//		}
//		catch (ClientProtocolException e) {
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
    }
	
//	private static String readStreamAsString(InputStream in) {
//		try {
//			ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
//			byte[] buffer = new byte[1024];
//			int count;
//			do {
//				count = in.read(buffer);
//				if (count > 0) {
//					out.write(buffer, 0, count);
//				}
//			} while (count >= 0);
//			
//			return out.toString("UTF-8");
//		}
//		catch (UnsupportedEncodingException e) {
//			throw new RuntimeException("The JVM does not support the compiler's default encoding.", e);
//		}
//		catch (IOException e) {
//			return null;
//		} 
//		finally {
//			try {
//				in.close();
//			}
//			catch (IOException ignored) {
//			}
//		}
//	}
//	
//	private static File readStreamAsFile(InputStream in) {
//		try {
//			File file = new File("resc/temp.jpeg");
//			FileOutputStream out = new FileOutputStream(file);
//			byte[] buffer = new byte[1024];
//			int count;
//			do {
//				count = in.read(buffer);
//				if (count > 0) {
//					out.write(buffer, 0, count);
//				}
//			} while (count >= 0);
//			out.flush();
//			out.close();
//			
//			return file;
//		}
//		catch (UnsupportedEncodingException e) {
//			throw new RuntimeException("The JVM does not support the compiler's default encoding.", e);
//		}
//		catch (IOException e) {
//			return null;
//		} 
//		finally {
//			try {
//				in.close();
//			}
//			catch (IOException ignored) {
//			}
//		}
//	}
}
