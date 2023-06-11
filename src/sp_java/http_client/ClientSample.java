package sp_java.http_client;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

public class ClientSample {
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.GET).send();
		System.out.println(contentRes.getContentAsString());
		System.out.println(contentRes.getHeaders());
	
		Request req = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.POST);
		req.header(HttpHeader.CONTENT_TYPE, "application/json");
		req.content(new StringContentProvider("hello~~~~~","utf-8"));
		contentRes = req.send();
		System.out.println(contentRes.getContentAsString());
		System.out.println(contentRes.getHeaders());
		httpClient.stop();
	}
}
