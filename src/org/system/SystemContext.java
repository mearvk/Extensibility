package org.system;

import org.system.http.HttpServer;
import org.system.publishment.PublishmentContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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

	public SystemPublishmentContext context;

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

	public SystemContext(Username username, Password password, SystemHTTPServer server, SystemContextChangeListener listener, SystemContextInitializer initializer, SystemContextStructure structure, SystemPublishmentContext context)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		this.context = context;

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
		public String protocol;

		public String url;
		public String username;

		public Username(String protocol, String url, String username)
		{
			this.protocol = protocol;

			this.url = url;

			this.username = username;
		}
	}

	public static class Password
	{
		public String protocol;
		public String url;
		public String password;

		public Password(String protocol, String url, String password)
		{
			this.protocol = protocol;

			this.url = url;

			this.password = password;
		}
	}

	public static class SystemContextChangeListener
	{
		public ArrayList<SystemContextStructure> structures = new ArrayList<>(100);

		public SystemContextHTTPServer server;

		public StateChangeEvent events = new StateChangeEvent(this);

		public OnUnregisterListener onunregisterlistener = new OnUnregisterListener(this);

		public OnRegisterListener onregisterlistener = new OnRegisterListener(this);

		public OnConnectListener onconnectlistener = new OnConnectListener(this);

		public OnAcceptListener onacceptlistener = new OnAcceptListener(this);

		public OnRejectListener onrejectlistener = new OnRejectListener(this);

		public OnQuitListener onquitlistener = new OnQuitListener(this);

		public SystemContextChangeListener(String project, String context, Integer port)
		{
			this.server = new SystemContextHTTPServer(project, context, port);
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
		public String type;

		public SystemContextChangeListener change_listener;

		public SystemContextInitializer(String type)
		{
			this.type = type;
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

		public String project = "";

		public String base = "";

		public String branch = "";

		public SystemContextStructure()
		{

		}

		public SystemContextStructure(String project, String base, String branch)
		{
			this.project = project;

			this.base = base;

			this.branch = branch;
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

	public static class SystemPublishmentContext
	{
		public SystemPublishmentContext(PublishmentContext context)
		{

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
		public static String canonicalURL = ".";

		public static String productionURL = "";

		public static String sharedURL = "";

		public static final String configFile = "context.txt";

		public ArrayList<Socket> connections = new ArrayList<Socket>();

		public Responder responder = new Responder(this);

		public Connector connector = new Connector(this);

		public String project;

		public String context;

		public Integer port;

		public SystemHTTPServer(String project, String context, Integer port)
		{
			this.project = project;

			this.context = context;

			this.port = port;

			try
			{
				SystemHTTPServer.canonicalURL = new File(SystemHTTPServer.canonicalURL).getCanonicalPath();

				SystemHTTPServer.productionURL = new File(".").getCanonicalPath() + "/out/production/mearvk";

				SystemHTTPServer.sharedURL = SystemHTTPServer.productionURL + File.separator + "shared" + File.separator + this.project;

				//

				File directory = new File(SystemHTTPServer.sharedURL);

				if(directory.isDirectory())
				{
					File config = new File(SystemHTTPServer.sharedURL+File.separator+SystemHTTPServer.configFile);

					if(config.exists())
					{
						BufferedReader reader = new BufferedReader(new FileReader(config.getCanonicalPath()));

						String line = null;

						while((line=reader.readLine())!=null)
						{
							try
							{
								File f = new File(SystemHTTPServer.canonicalURL+File.separator+SystemHTTPServer.sharedURL+File.separator+line);

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
						File f = new File(SystemHTTPServer.sharedURL+File.separator+this.port.toString()+File.separator+this.context);

						f.mkdirs();

						f = null;
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					directory.mkdirs();
				}}
			catch(Exception e)
			{
				System.out.println("Error Creating Server Directories; Please Configure Yourself. It.");
			}

			this.connector.start();

			this.responder.start();
		}

		public static class Connector extends Thread
		{
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
						this.ss = new ServerSocket(this.reference.port);

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

		public static class Responder extends Thread
		{
			public SystemHTTPServer reference;

			public ArrayList<Socket> connections;

			public Responder(SystemHTTPServer reference)
			{
				this.reference = reference;

				this.connections = reference.connections;
			}

			@Override
			public void run()
			{
				for(;;)
				{
					Socket socket = null;

					try
					{
						Thread.sleep(25);

						StringBuffer buffer = new StringBuffer();

						String line;

						BufferedWriter writer;

						BufferedReader reader;

						if(this.connections.size()>0)
						{
							socket = this.connections.remove(0);

							socket.setKeepAlive(true);

							reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

							line = reader.readLine();

							reader = new BufferedReader(new FileReader(new File(SystemHTTPServer.sharedURL+File.separator+line)));

							writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

							while((line=reader.readLine())!=null)
							{
								try
								{
									buffer.append(line);
								}
								catch (Exception e)
								{
									buffer.append(">> Error exception: "+e.getStackTrace().toString());

									System.out.println(e);
								}
							}

							if(buffer.length()>0)
							{
								writer.write(buffer.toString());

								writer.flush();
							}

							writer.close();

							writer = null;
						}
					}
					catch(SocketException se)
					{
						if(se.getMessage().trim().toLowerCase().contains("closed"))
						{
							try
							{
								socket.close();

								socket = null;
							}
							catch(Exception e)
							{
								System.out.println(">> Error exception: please handle yourself.");
							}
						}
					}
					catch(Exception e)
					{
						System.out.println(">> Error exception: please handle yourself.");
					}
				}
			}
		}
	}

	public static class SystemContextHTTPServer
	{
		public static String canonicalURL = ".";

		public static String productionURL = "";

		public static String sharedURL = "";

		public static final String fileURL = "context";

		public static final String configFile = "context.txt";

		public ArrayList<Socket> connections = new ArrayList<Socket>();

		public Responder responder = new Responder(this);

		public Connector connector = new Connector(this);

		public String project;

		public String context;

		public Integer port;

		public SystemContextHTTPServer(String project, String context, Integer port)
		{
			this.project = project;

			this.context = context;

			this.port = port;

			//

			try
			{
				SystemContextHTTPServer.canonicalURL = new File(SystemContextHTTPServer.canonicalURL).getCanonicalPath();

				SystemContextHTTPServer.productionURL = new File(".").getCanonicalPath() + "/out/production/mearvk";

				SystemContextHTTPServer.sharedURL = SystemContextHTTPServer.productionURL + File.separator + "shared" + File.separator + this.project;

				//

				File directory = new File(SystemContextHTTPServer.sharedURL);

				if(directory.isDirectory())
				{
					File config = new File(SystemContextHTTPServer.sharedURL+File.separator+SystemContextHTTPServer.configFile);

					if(config.exists())
					{
						BufferedReader reader = new BufferedReader(new FileReader(config.getCanonicalPath()));

						String line = null;

						while((line=reader.readLine())!=null)
						{
							try
							{
								File f = new File(SystemContextHTTPServer.sharedURL+File.separator+line);

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
						File f = new File(SystemContextHTTPServer.sharedURL+File.separator+this.port.toString()+File.separator+this.context);

						f.mkdirs();

						f = null;
					}
					catch(Exception e)
					{
						e.printStackTrace();
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

			this.connector.start();

			this.responder.start();
		}

		public static class Connector extends Thread
		{
			public ServerSocket ss;

			public SystemContextHTTPServer reference;

			public Connector(SystemContextHTTPServer reference)
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
						this.ss = new ServerSocket(this.reference.port);

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

		public static class Responder extends Thread
		{
			public SystemContextHTTPServer reference;

			public ArrayList<Socket> connections;

			public Responder(SystemContextHTTPServer reference)
			{
				this.reference = reference;

				this.connections = reference.connections;
			}

			@Override
			public void run()
			{
				for(;;)
				{
					Socket socket = null;

					try
					{
						Thread.sleep(25);

						StringBuffer buffer = new StringBuffer();

						String line;

						BufferedWriter writer;

						BufferedReader reader;

						if(this.connections.size()>0)
						{
							socket = this.connections.remove(0);

							socket.setKeepAlive(true);

							reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

							line = reader.readLine();

							reader = new BufferedReader(new FileReader(new File(SystemContextHTTPServer.canonicalURL+File.separator+SystemContextHTTPServer.sharedURL+File.separator+line)));

							writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

							while((line=reader.readLine())!=null)
							{
								try
								{
									buffer.append(line);
								}
								catch (Exception e)
								{
									buffer.append(e.getStackTrace().toString());

									System.out.println(">> Error exception: "+e.getStackTrace().toString());
								}
							}

							if(buffer.length()>0)
							{
								writer.write(buffer.toString());

								writer.flush();
							}

							writer.close();

							writer = null;
						}
					}
					catch(SocketException se)
					{
						if(se.getMessage().trim().toLowerCase().contains("closed"))
						{
							try
							{
								socket.close();

								socket = null;
							}
							catch(Exception e)
							{
								System.out.println(">> Error exception: "+e.getStackTrace().toString());
							}
						}
					}
					catch(Exception e)
					{
						System.out.println(">> Error exception: "+e.getStackTrace().toString());
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
