package org.system;

import org.system.servers.context.HttpCallContext;
import java.net.Socket;
import java.util.Date;

public class SocketDatagram implements Comparable<SocketDatagram>
{
	public static final int FINAL = 5;
	public Date timestamp = new Date(System.currentTimeMillis());

	public HttpCallContext context;

	public Socket socket;

	public org.system.servers.HttpServer server;

	public int type;

	public SocketDatagram(int type, SocketDatagram datagram)
	{
		this.type = type;

		this.server = datagram.server;

		this.context = datagram.context;

		this.socket = datagram.socket;
	}

	public SocketDatagram(int type, Socket socket)
	{
		this.type = type;

		this.socket = socket;

		this.context = new HttpCallContext();
	}

	public SocketDatagram(int type, Socket socket, org.system.servers.HttpServer server)
	{
		this.type = type;

		this.socket = socket;

		this.server = server;

		this.context = new HttpCallContext();
	}

	public SocketDatagram(int type)
	{
		this.type = type;
	}

	public int compareTo(SocketDatagram datagram)
	{
		if (this.timestamp.before(datagram.timestamp))
			return +1;

		if (this.timestamp.after(datagram.timestamp))
			return -1;

		return 0;
	}
}
