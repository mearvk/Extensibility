package org.system.servers.runners;

import org.system.SocketDatagram;
import org.system.SystemRunner;

public class Runnable_002 extends Thread implements SystemRunner
{
	public SocketDatagram datagram;

	public Runnable_002(SocketDatagram datagram)
	{
		this.datagram = datagram;
	}

	public void run()
	{
		System.out.println("Datagram [2] >> " + datagram);
	}
}
