package org.system.http.runners;

import org.system.SocketDatagram;
import org.system.SystemRunner;

public class Runnable_004 extends Thread implements SystemRunner
{
	public SocketDatagram datagram;

	public Runnable_004(SocketDatagram datagram)
	{
		this.datagram = datagram;
	}

	public void run()
	{
		System.out.println("Datagram [4] >> " + datagram);
	}
}
