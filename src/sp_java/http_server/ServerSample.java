package sp_java.http_server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class ServerSample {
	public static String name;
	
	public static void main(String[] args) throws Exception {
		ServerSample.name = "park";
		
		
		new ServerSample().start();
	}

	public void start() throws Exception {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(ServletSample.class, "/*");
		server.setHandler(servletHandler);

		server.start();
		server.join();
	}

}
