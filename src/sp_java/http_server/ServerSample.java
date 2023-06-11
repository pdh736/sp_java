package sp_java.http_server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerSample {
	Server server;
	
	ServerSample() {
		server = new Server();
	}
	
	public void start() throws Exception {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);

		//ServletHandler servletHandler = new ServletHandler();
		//servletHandler.addServletWithMapping(ServletSample.class, "/*");
		//server.setHandler(servletHandler);
		
		ServletSample servlet = new ServletSample("Test Server");
		ServletHolder holder = new ServletHolder(servlet);
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(holder, "/*");
		server.setHandler(servletHandler);
		
		server.start();
	}
	
	public void join() throws Exception {
		server.join();
	}
}
