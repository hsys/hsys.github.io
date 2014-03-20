package net.taobao.test;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettyStarter {
	
	public static void main(String[] arags) throws Exception{
		Server server =  new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setWar("src/main/webapp");
		context.setContextPath("/");
		server.setHandler(context);
		server.start();
		server.join();
	}

}
