package org.system.rmi.http.runners;

import org.system.SocketDatagram;
import org.system.SystemRunner;

public class Runnable_004 extends Thread implements SystemRunner
{
	public org.system.rmi.SocketDatagram datagram;

	public Runnable_004(org.system.rmi.SocketDatagram datagram)
	{
		this.datagram = datagram;
	}

	public void run()
	{
		System.out.println("Datagram [4] >> " + datagram);
	}
}
