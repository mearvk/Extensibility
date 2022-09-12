package org.system.http.runners;

import org.system.SocketDatagram;
import org.system.SystemRunner;

import java.io.InputStream;
import java.util.Date;

public class Runnable_000 extends Thread implements SystemRunner
{
	public SocketDatagram datagram;

	public Runnable_000(org.system.SocketDatagram datagram)
	{
		this.datagram = datagram;
	}

	@Override public void run()
	{
		System.out.println("Datagram [0] >> " + datagram);

		boolean is_running = true;

		for (; is_running; )
		{
			try
			{
				InputStream is = datagram.socket.getInputStream();

				if (is.available() == 0)
				{
					continue;
				}
				else
				{
					this.datagram.context.timestamp = new Date(System.currentTimeMillis());

					this.datagram.context.content = new ContentString(this.datagram).content;

					this.datagram.server.interpreter.thread.interpret(1, datagram).struct.add(new SocketDatagram(1, datagram.socket));
				}

				Thread.sleep(20);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
