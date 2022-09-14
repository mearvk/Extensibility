package org.system;

import org.system.http.HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SystemContext
{
	public Username username;

	public Password password;

	public SystemHTTPServer server;

	public SystemProgram program;

	public ArrayList<SystemPublishment> publishments;

	public SystemContextChangeListener listener;

	public SystemContextInitializer initializer;

	public SystemContextStructure structure;

	public SystemContext(Username username, Password password, SystemProgram program)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		SystemContextStructure.BASE.contexts.add(this);
	}

	public SystemContext(Username username, Password password, SystemProgram program, SystemContextChangeListener listener, SystemContextInitializer initializer)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		this.listener = listener;

		this.initializer = initializer;

		SystemContextStructure.BASE.contexts.add(this);
	}

	public SystemContext(Username username, Password password, SystemProgram program, SystemContextChangeListener listener, SystemContextInitializer initializer, SystemContextStructure structure)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		SystemContextStructure.BASE.contexts.add(this);
	}

	public SystemContext(Username username, Password password, SystemContextChangeListener listener, SystemContextInitializer initializer, SystemContextStructure structure, SystemPublishment...publishments)
	{
		this.username = username;

		this.password = password;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		this.publishments = new ArrayList<SystemPublishment>(Arrays.asList(publishments));

		SystemContextStructure.BASE.contexts.add(this);
	}

	public SystemContext(Username username, Password password, SystemProgram program, SystemContextChangeListener listener, SystemContextInitializer initializer, SystemContextStructure structure, SystemPublishment...publishments)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		this.publishments = new ArrayList<SystemPublishment>(Arrays.asList(publishments));

		SystemContextStructure.BASE.contexts.add(this);
	}

	public SystemContext(Username username, Password password, SystemHTTPServer server, SystemContextChangeListener listener, SystemContextInitializer initializer, SystemContextStructure structure, SystemPublishment...publishments)
	{
		this.username = username;

		this.password = password;

		this.server = server;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		this.publishments = new ArrayList<SystemPublishment>(Arrays.asList(publishments));

		SystemContextStructure.BASE.contexts.add(this);
	}

	public static class SamRegistry
	{
		public String registryURL;

		public SamRegistry(String registryURL)
		{
			this.registryURL = registryURL;
		}
	}

	public static class Username
	{
		public String username;

		public Username(String username)
		{
			this.username = username;
		}
	}

	public static class Password
	{
		public String password;

		public Password(String password)
		{
			this.password = password;
		}
	}

	public static class SystemContextChangeListener
	{
		public static final Integer PORT = 7777;

		public ArrayList<SystemContextStructure> structures = new ArrayList<>(100);
		public HttpServer server;
		public String url;

		public StateChangeEvent events = new StateChangeEvent(this);

		public OnUnregisterListener onunregisterlistener = new OnUnregisterListener(this);

		public OnRegisterListener onregisterlistener = new OnRegisterListener(this);

		public OnConnectListener onconnectlistener = new OnConnectListener(this);

		public OnAcceptListener onacceptlistener = new OnAcceptListener(this);

		public OnRejectListener onrejectlistener = new OnRejectListener(this);

		public OnQuitListener onquitlistener = new OnQuitListener(this);

		public SystemContextChangeListener(String url, Integer port)
		{
			this.url = url;

			this.server = new HttpServer(port);

			this.server.publish(this.url);
		}

		public SystemContextChangeListener()
		{
			this.server = new HttpServer(PORT);
		}

		public static class StateChangeEvent
		{
			public SystemContextChangeListener listener;

			public StateChangeEvent(SystemContextChangeListener systemlistener)
			{
				this.listener = systemlistener;
			}
		}

		public static class OnAcceptListener implements ContextListener, Registrar
		{
			public ArrayList<OnAcceptListener> listeners = new ArrayList<>(100);

			public SystemContextChangeListener systemlistener;

			public OnAcceptListener(SystemContextChangeListener listener)
			{
				this.systemlistener = listener;
			}

			public void register(ContextListener listener)
			{
				this.listeners.add((OnAcceptListener) listener);
			}
		}

		public static class OnRejectListener implements ContextListener, Registrar
		{
			public ArrayList<OnRejectListener> listeners = new ArrayList<>(100);
			public SystemContextChangeListener systemlistener;

			public OnRejectListener(SystemContextChangeListener listener)
			{
				this.systemlistener = listener;
			}

			public void register(ContextListener listener)
			{
				this.listeners.add((OnRejectListener) listener);
			}
		}

		public static class OnRegisterListener implements ContextListener, Registrar
		{
			public ArrayList<OnRegisterListener> listeners = new ArrayList<>(100);
			public SystemContextChangeListener systemlistener;

			public OnRegisterListener(SystemContextChangeListener listener)
			{
				this.systemlistener = listener;
			}

			public void register(ContextListener listener)
			{
				this.listeners.add((OnRegisterListener) listener);
			}
		}

		public static class OnUnregisterListener implements ContextListener, Registrar
		{
			public ArrayList<OnUnregisterListener> listeners = new ArrayList<>(100);
			public SystemContextChangeListener systemlistener;

			public OnUnregisterListener(SystemContextChangeListener listener)
			{
				this.systemlistener = listener;
			}

			public void register(ContextListener listener)
			{
				this.listeners.add((OnUnregisterListener) listener);
			}
		}

		public static class OnQuitListener implements ContextListener, Registrar
		{
			public ArrayList<OnQuitListener> listeners = new ArrayList<>(100);
			public SystemContextChangeListener systemlistener;

			public OnQuitListener(SystemContextChangeListener listener)
			{
				this.systemlistener = listener;
			}

			public void register(ContextListener listener)
			{
				this.listeners.add((OnQuitListener) listener);
			}
		}

		public static class OnConnectListener implements ContextListener, Registrar
		{
			public ArrayList<OnConnectListener> listeners = new ArrayList<>(100);
			public SystemContextChangeListener systemlistener;

			public OnConnectListener(SystemContextChangeListener listener)
			{
				this.systemlistener = listener;
			}

			public void register(ContextListener listener)
			{
				this.listeners.add((OnConnectListener) listener);
			}
		}
	}

	public static class SystemProgram
	{
		public ArrayList<SystemRunner> runnables = new ArrayList<SystemRunner>();

		public SystemProgram(SystemRunner...runners)
		{
			Collections.addAll(runnables, runners);
		}
	}

	public static class SystemContextInitializer
	{
		public String reference_id;

		public SystemContextChangeListener change_listener;

		public SystemContextInitializer(String reference_id)
		{
			this.reference_id = reference_id;
		}
	}

	public static class SystemContextStructure
	{
		public static final SystemContextStructure BASE = new SystemContextStructure();

		public ArrayList<SystemPublishment> running = new ArrayList<SystemPublishment>();

		public ArrayList<SystemPublishment> stopping = new ArrayList<SystemPublishment>();

		public ArrayList<SystemPublishment> starting = new ArrayList<SystemPublishment>();

		public ArrayList<SystemContextStructure> structures = new ArrayList<SystemContextStructure>();
		public ArrayList<SystemContext> contexts = new ArrayList<SystemContext>();

		public String base = "//";

		public SystemContextStructure()
		{

		}

		public SystemContextStructure(String base, String branch)
		{

		}

		public void add(String context, SystemPublishment publishment)
		{
			if(context.equals("start"))
			{
				this.starting.add(publishment);
			}

			if(context.equals("running"))
			{
				this.running.add(publishment);
			}

			if(context.equals("stop"))
			{
				this.stopping.add(publishment);
			}
		}
	}

	public static class SystemPublishment
	{
		public SystemPublishment(Integer order, SystemPart part)
		{

		}

		public SystemPublishment(Integer order, SystemPart part, SystemPartParametry parametry, SamRegistry samregistry, Username username, Password password)
		{

		}

		public SystemPublishment(Integer order, SystemPart part, SystemPartParametry parametry, Username username, Password password)
		{

		}
		public SystemPublishment(Integer order, SystemPart part, SystemPartParametry parametry)
		{

		}

		public static class SystemPart
		{
			public SystemPart()
			{

			}

			public SystemPart(Object object)
			{

			}

			public SystemPart(Class klass)
			{

			}
		}

		public static class SystemPartParametry
		{
			public Integer partnumber;

			public Integer commonpartnumber;

			public String document;

			public File file;

			public SystemPartParametry(Integer part_number, Integer common_part_number, String document)
			{
				this.partnumber = part_number;

				this.commonpartnumber = common_part_number;

				this.document = document;
			}
		}
	}

	public static class SystemHTTPServer
	{
		public String canonicalURL = "";

		public static final String baseURL = "/server";
		public static final String configFile = "context.txt";

		public Responder responder = new Responder(this);

		public Connector connector = new Connector(this);

		public ArrayList<Socket> connections = new ArrayList<Socket>();

		public String context;

		public Integer port;

		public SystemHTTPServer(String context, Integer port)
		{
			this.context = context;

			this.port = port;

			//

			try
			{
				this.canonicalURL = new File(".").getCanonicalPath();

				File directory = new File(this.canonicalURL+File.separator+SystemHTTPServer.baseURL);

				if(directory.isDirectory())
				{
					File config = new File(this.canonicalURL+File.separator+SystemHTTPServer.baseURL+File.separator+SystemHTTPServer.configFile);

					if(config.exists())
					{
						BufferedReader reader = new BufferedReader(new FileReader(config.getCanonicalPath()));

						String line = null;

						while((line=reader.readLine())!=null)
						{
							try
							{
								File f = new File(this.canonicalURL+File.separator+SystemHTTPServer.baseURL+File.separator+line);

								if(!f.exists())
								{
									f.mkdirs();
								}
							}
							catch (Exception e)
							{
								System.out.println("Error Creating Server Directories; Please Configure Yourself.");
							}
						}
					}

					try
					{
						File f = new File(SystemHTTPServer.baseURL+File.separator+this.context);

						f.mkdirs();

						f = null;
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				else
				{
					directory.mkdirs();
				}
			}
			catch(Exception e)
			{
				System.out.println("Error Creating Server Directories; Please Configure Yourself. It.");
			}

			this.context = context;

			this.port = port;
		}

		public static class Connector implements Runnable
		{
			public Integer port;
			public ServerSocket ss;

			public SystemHTTPServer reference;

			public Connector(SystemHTTPServer reference)
			{
				this.reference = reference;
			}

			@Override
			public void run()
			{
				for(;;)
				{
					Socket s;

					try
					{
						this.ss = new ServerSocket(this.port);

						s = this.ss.accept();

						this.reference.connections.add(s);
					}
					catch (Exception e)
					{
						return;
					}
				}
			}
		}

		public static class Responder implements Runnable
		{
			public SystemHTTPServer reference;

			public Integer port;

			public ArrayList<Socket> connections = new ArrayList<Socket>();

			public Responder(SystemHTTPServer reference)
			{
				this.reference = reference;
			}

			@Override
			public void run()
			{
				for(;;)
				{
					try
					{
						BufferedReader reader01 = new BufferedReader(new FileReader(new File("")));

						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.reference.connections.get(0).getOutputStream()));

						String line = "";

						while((line=reader01.readLine())!=null)
						{
							writer.write(line);

							writer.flush();
						}

						writer.close();

						writer = null;
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		}
	}

	public interface ContextListener
	{

	}

	public interface Registrar
	{
		void register(ContextListener listener);
	}
}
