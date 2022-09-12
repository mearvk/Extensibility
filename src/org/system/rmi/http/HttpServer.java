package org.system.rmi.http;

import org.system.SocketDatagram;
import org.system.rmi.http.context.HttpCallContext;
import org.system.rmi.http.interpreter.SocketDatagramInterpreter;
import org.system.rmi.http.runners.Runnable_000;

import java.io.BufferedReader;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class HttpServer
{
	public SocketDatagramInterpreter interpreter;

	public PollingThread pollingthread;

	public WebContextPollingThread webcontextpollingthread;

	public ServerSocket serversocket;

	public Integer port;

	public ArrayList<HttpCallContext> contexts = new ArrayList<HttpCallContext>(100);

	public HttpServer(Integer port)
	{
		this.port = port;

		try
		{
			this.serversocket = new ServerSocket(this.port);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		this.interpreter = new SocketDatagramInterpreter();

		this.pollingthread = new PollingThread(this);

		this.pollingthread.start();

		this.webcontextpollingthread = new WebContextPollingThread(this);

		this.webcontextpollingthread.start();
	}

	public void publish(String url)
	{
		this.contexts.add(new HttpCallContext(url));
	}

	public static class PollingThread extends Thread
	{
		public org.system.rmi.http.HttpServer server;

		public boolean running = false;

		public PollingThread(org.system.rmi.http.HttpServer server)
		{
			this.server = server;
		}

		@Override
		public void run()
		{
			BufferedReader reader = null;

			Socket socket = null;

			String line = null;

			boolean running = true;

			try
			{
				for(;running;)
				{
					socket = this.server.serversocket.accept();

					new org.system.rmi.http.runners.Runnable_000(new org.system.rmi.SocketDatagram(0, socket, this.server)).start();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public static class WebContextPollingThread extends Thread
	{
		public ArrayList<WebContextPollen> pollens = new ArrayList<WebContextPollen>();

		public HttpServer server;

		public String web_application_url = "/";

		public WebContextPollingThread(HttpServer server)
		{
			this.server = server;
		}

		public static class WebContextPollen
		{
			public File web_inf;

			public File meta_inf;

			public String baseURL;

			public WebContextPollen()
			{

			}
		}

		@Override
		public void run()
		{
			boolean running = true;

			for(;running;)
			{
				BufferedReader reader;

				File[] files;

				for(File file : Objects.requireNonNull(new File(web_application_url).listFiles()))
				{
					WebContextPollen pollen = new WebContextPollen();

					if(file.isDirectory())
					{
						if(file.getName().equals("WEB-INF"))
						{
							pollen.web_inf = file;
						}

						if(file.getName().equals("META-INF"))
						{
							pollen.meta_inf = file;
						}
					}
					else
					{
						pollen.baseURL = file.getAbsolutePath();
					}
				}
			}
		}
	}
}
