package org.system.rmi.http.runners;

import org.system.SocketDatagram;
import org.system.SystemRunner;
import org.system.rmi.http.sorting.HttpRequest;
import org.system.rmi.http.sorting.HttpRequestFilter;

public class Runnable_001 extends Thread implements SystemRunner
{
	public org.system.rmi.SocketDatagram datagram;

	public Runnable_001(org.system.rmi.SocketDatagram datagram)
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

				this.datagram.server.interpreter.thread.interpret(2, datagram).struct.add(new org.system.rmi.SocketDatagram(2, datagram.socket));

				Thread.sleep(20);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
