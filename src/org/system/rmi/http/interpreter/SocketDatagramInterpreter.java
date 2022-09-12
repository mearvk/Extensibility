package org.system.rmi.http.interpreter;

import org.system.SocketDatagram;
import org.system.rmi.http.runners.Runnable_001;
import org.system.rmi.http.runners.Runnable_002;
import org.system.rmi.http.runners.Runnable_003;
import org.system.rmi.http.runners.Runnable_004;

import java.util.PriorityQueue;

public class SocketDatagramInterpreter
{
	public PriorityQueue<org.system.rmi.SocketDatagram> struct = new PriorityQueue<org.system.rmi.SocketDatagram>();

	public SocketDatagramInterpreterThread thread = new SocketDatagramInterpreterThread(this);

	public SocketDatagramInterpreter()
	{
		this.thread.start();
	}

	public static class SocketDatagramInterpreterThread extends Thread
	{
		public SocketDatagramInterpreter interpreter;

		public boolean is_running = false;

		public SocketDatagramInterpreterThread(SocketDatagramInterpreter interpreter)
		{
			this.interpreter = interpreter;
		}

		public SocketDatagramInterpreter interpret(int type, org.system.rmi.SocketDatagram datagram)
		{
			if (datagram == null || type <= 0 || type > 4)
				return this.interpreter;

			if (type == 1)
			{
				new Runnable_001(datagram).start();
			}
			else if (type == 2)
			{
				new Runnable_002(datagram).start();
			}
			else if (type == 3)
			{
				new Runnable_003(datagram).start();
			}
			else if (type == 4)
			{
				new Runnable_004(datagram).start();
			}

			return this.interpreter;
		}

		public void run()
		{
			this.is_running = true;

			for (; this.is_running; )
			{
				org.system.rmi.SocketDatagram datagram = null;

				try
				{
					if ((datagram = this.interpreter.struct.poll()) == null)
					{
						Thread.sleep(20);

						continue;
					}

					if (datagram.type == 0)
					{
						System.setProperty("//packet/" + datagram + "/stepping/0", datagram.toString());

						System.setProperty("//packet/" + datagram + "/", datagram.context.content);

						this.interpret(1, datagram).struct.add(new org.system.rmi.SocketDatagram(1, datagram.socket));
					}
					else if (datagram.type == 1)
					{
						System.setProperty("//packet/" + datagram + "/stepping/1", datagram.context.content);

						System.setProperty("//packet/" + datagram + "/", datagram.context.content);

						this.interpret(2, datagram).struct.add(new org.system.rmi.SocketDatagram(2, datagram.socket));
					}
					else if (datagram.type == 2)
					{
						System.setProperty("//packet/" + datagram + "/stepping/2", datagram.context.content);

						System.setProperty("//packet/" + datagram + "/", datagram.context.content);

						this.interpret(3, datagram).struct.add(new org.system.rmi.SocketDatagram(3, datagram.socket));
					}
					else if (datagram.type == 3)
					{
						System.setProperty("//packet/" + datagram + "/stepping/3", datagram.context.content);

						System.setProperty("//packet/" + datagram + "/", datagram.context.content);

						this.interpret(4, datagram).struct.add(new org.system.rmi.SocketDatagram(4, datagram.socket));
					}
					else if (datagram.type == 4)
					{
						System.setProperty("//packet/" + datagram + "/stepping/4", datagram.context.content);

						System.setProperty("//packet/" + datagram + "/", datagram.context.content);

						this.interpret(5, datagram).struct.add(new org.system.rmi.SocketDatagram(SocketDatagram.FINAL, datagram.socket));
					}

					Thread.sleep(20);
				}
				catch (InterruptedException ie)
				{/* */}
				catch (IndexOutOfBoundsException ioobe)
				{/* */}
				catch (Exception e)
				{
					e.printStackTrace();

					return;
				}
			}
		}
	}


}