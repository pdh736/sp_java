package sp_java.http_client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

public class ClientSample {

	ContentResponse doGet(String url){
		HttpClient httpClient = new HttpClient();
		
		
		ContentResponse contentRes = null;
		try {
			httpClient.start();
			contentRes = httpClient.newRequest(url).method(HttpMethod.GET).send();
			httpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(contentRes.getContentAsString());
		//System.out.println(contentRes.getHeaders());
		
		return contentRes;

	}
	
	ContentResponse doPost(String url, String content) {
		HttpClient httpClient = new HttpClient();
		ContentResponse contentRes = null;
		try {
			httpClient.start();
			Request req = httpClient.newRequest(url).method(HttpMethod.POST);
			//req.header(HttpHeader.CONTENT_TYPE, "application/json");
			if(content != null)
				req.content(new StringContentProvider(content, "utf-8"));
			
			contentRes = req.send();
			
			httpClient.stop();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(contentRes.getContentAsString());
		//System.out.println(contentRes.getHeaders());
		
		return contentRes;
	}
}
