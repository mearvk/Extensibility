package org.system.servers.runners;

import org.system.SocketDatagram;
import org.system.SystemRunner;
import org.system.servers.sorting.HttpRequest;
import org.system.servers.sorting.HttpRequestFilter;

public class Runnable_001 extends Thread implements SystemRunner
{
	public SocketDatagram datagram;

	public Runnable_001(SocketDatagram datagram)
	{
		this.datagram = datagram;
	}

	@Override
	public void run()
	{
		System.out.println("Datagram [1] >> " + datagram + " >> "+datagram.context.content);

		boolean is_running = false;

		for (; is_running; )
		{
			try
			{
				HttpRequestFilter filter = new HttpRequestFilter(datagram);

				HttpRequest request = new HttpRequest(datagram);

				this.datagram.server.interpreter.thread.interpret(2, datagram).struct.add(new SocketDatagram(2, datagram.socket));

				Thread.sleep(20);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
