package com.taobao.webx;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyStarter {
	
	public static void main(String[]args) throws Exception{
		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setWar("src/main/webapp");
		context.setContextPath("/");
		server.setHandler(context);
		server.start();
		server.join();
	}

}
