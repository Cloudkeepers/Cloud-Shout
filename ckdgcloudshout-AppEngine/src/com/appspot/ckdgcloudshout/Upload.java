package com.appspot.ckdgcloudshout;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plaintext");
		resp.getWriter().print("hello world");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		BlobKey key = blobs.get("fileKey").get(0);
		resp.getWriter().print(key.getKeyString());
	}
	
//	List<FileItem> items;
//	try {
//		items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
//		 for (FileItem item : items) {
//		        if (item.getFieldName().equals("fieldname")) {
//		            String fileName = FilenameUtils.getName(item.getName());
//		            String fileContentType = item.getContentType();
//		            InputStream fileContent = item.getInputStream();
//		        }
//		    }
//	}
//	catch (FileUploadException e) {
//		e.printStackTrace();
//	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		Entity entity = new Entity("derr");
//		entity.setProperty("content", new Object());
//	}
	
//	 postMethod.setRequestBody(new FileInputStream(f));
//     postMethod.setRequestHeader("Content-type",
//         "text/xml; charset=ISO-8859-1");
//
//     int statusCode1 = client.executeMethod(postMethod);
}