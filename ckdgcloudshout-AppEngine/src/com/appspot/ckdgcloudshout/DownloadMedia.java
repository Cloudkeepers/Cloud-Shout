package com.appspot.ckdgcloudshout;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class DownloadMedia extends HttpServlet {
	private static final long serialVersionUID = 5827052219540204475L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getParameterMap();
		BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
		blobstoreService.serve(blobKey, resp);
		
//		Query query = new Query("__BlobInfo__"); 
//		query.addFilter("filename", FilterOperator.EQUAL, "IMG_0820.JPG"); 
//
//		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService(); 
//		PreparedQuery preparedQuery = datastore.prepare(query); 
//		List<Entity> entities = preparedQuery.asList(FetchOptions.Builder.withLimit(1));
//		
//		req.getParameter("blob-key");
//		
//		resp.setContentType("image/jpeg");
//		resp.getOutputStream().write(entities.get(0).);
	}
}


//PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
//Query query = persistenceManager.newQuery(Media.class, "key == keyParam");
//query.declareParameters("String keyParam");
//query.setRange(0, 1);
//
//List<Media> results = (List<Media>) query.execute("ag5Da2RnY2xvdWRzaG91dHIoCxIMX19CbG9iSW5mb19fIhYwZnpSTk5nTFBtLVoyT1dvQXAxS2lRDA");
//
// resp.setContentType("image/jpeg");
// resp.getOutputStream().write(results.get(0).getMedia().getBytes());