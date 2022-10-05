package org.system.servers.runners;

import org.system.SocketDatagram;

public class Runnable_005 extends Thread implements Runnable
{
	public SocketDatagram datagram;

	public Runnable_005(SocketDatagram datagram)
	{
		this.datagram = datagram;
	}

	public void run()
	{
		System.out.println("Datagram [5] >> " + datagram);
	}
}
