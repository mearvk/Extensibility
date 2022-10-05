package org.system.servers.runners;

import org.system.SocketDatagram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ContentString
{
	public Socket socket;

	public String content;

	public ContentString(SocketDatagram datagram)
	{
		BufferedReader reader;

		try
		{
			reader = new BufferedReader(new InputStreamReader(datagram.socket.getInputStream()));

			String lines = "";

			String line = "";

			while (reader.ready() && (line = reader.readLine()) != null)
			{
				lines = lines + line;
			}

			this.content = datagram.context.content = lines;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
