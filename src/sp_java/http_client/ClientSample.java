package sp_java.http_client;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

public class ClientSample {

	ContentResponse doGet(String url) throws Exception{
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		
		ContentResponse contentRes = httpClient.newRequest(url).method(HttpMethod.GET).send();
		
		httpClient.stop();
		
		System.out.println(contentRes.getContentAsString());
		System.out.println(contentRes.getHeaders());
		
		return contentRes;

	}
	
	ContentResponse doPost(String url, String content) throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		
		Request req = httpClient.newRequest(url).method(HttpMethod.POST);
		//req.header(HttpHeader.CONTENT_TYPE, "application/json");
		if(content != null)
			req.content(new StringContentProvider(content, "utf-8"));
		ContentResponse contentRes = req.send();
		
		httpClient.stop();
		//System.out.println(contentRes.getContentAsString());
		//System.out.println(contentRes.getHeaders());
		
		return contentRes;
	}
}
