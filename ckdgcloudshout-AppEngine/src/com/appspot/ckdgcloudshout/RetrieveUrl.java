package com.appspot.ckdgcloudshout;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class RetrieveUrl extends HttpServlet {
	private static final long serialVersionUID = 4978565856134406050L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BlobstoreService service = BlobstoreServiceFactory.getBlobstoreService();
		resp.addHeader("uploadUrl", service.createUploadUrl("/upload"));
	}
}