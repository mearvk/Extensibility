package org.system.rmi;

import org.system.servers.HttpServer;
import org.system.SystemRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RMISystemContext
{
	public Username username;

	public Password password;

	public SystemProgram program;

	public ArrayList<SystemPublishment> publishments;

	public SystemContextChangeListener listener;

	public SystemContextInitializer initializer;

	public Structure structure;

	public RMISystemContext(Username username, Password password, SystemProgram program)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		Structure.BASE.contexts.add(this);
	}

	public RMISystemContext(Username username, Password password, SystemProgram program, SystemContextChangeListener listener, SystemContextInitializer initializer)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		this.listener = listener;

		this.initializer = initializer;

		Structure.BASE.contexts.add(this);
	}

	public RMISystemContext(Username username, Password password, SystemProgram program, SystemContextChangeListener listener, SystemContextInitializer initializer, Structure structure)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		Structure.BASE.contexts.add(this);
	}

	public RMISystemContext(Username username, Password password, SystemContextChangeListener listener, SystemContextInitializer initializer, Structure structure, SystemPublishment...publishments)
	{
		this.username = username;

		this.password = password;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		this.publishments = new ArrayList<SystemPublishment>(Arrays.asList(publishments));

		Structure.BASE.contexts.add(this);
	}

	public RMISystemContext(Username username, Password password, SystemProgram program, SystemContextChangeListener listener, SystemContextInitializer initializer, Structure structure, SystemPublishment...publishments)
	{
		this.username = username;

		this.password = password;

		this.program = program;

		this.listener = listener;

		this.initializer = initializer;

		this.structure = structure;

		this.publishments = new ArrayList<SystemPublishment>(Arrays.asList(publishments));

		Structure.BASE.contexts.add(this);
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

		public ArrayList<Structure> structures = new ArrayList<>(100);

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

			this.server = new org.system.servers.HttpServer(port);

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

	public static class Structure
	{
		public static final Structure BASE = new Structure();

		public ArrayList<SystemPublishment> running = new ArrayList<SystemPublishment>();

		public ArrayList<SystemPublishment> stopping = new ArrayList<SystemPublishment>();

		public ArrayList<SystemPublishment> starting = new ArrayList<SystemPublishment>();

		public ArrayList<Structure> structures = new ArrayList<Structure>();
		public ArrayList<RMISystemContext> contexts = new ArrayList<RMISystemContext>();

		public String base = "//";

		public Structure()
		{

		}

		public Structure(String base, String branch)
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
			public Integer part_number;

			public Integer common_part_number;

			public String document;

			public File file;

			public SystemPartParametry(Integer part_number, Integer common_part_number, String document)
			{
				this.part_number = part_number;

				this.common_part_number = common_part_number;

				this.document = document;
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
