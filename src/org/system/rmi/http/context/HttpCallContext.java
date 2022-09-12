package org.system.rmi.http.context;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class HttpCallContext
{
	public String url = "";

	public String content = "";

	public Date timestamp;

	public HashMap<Exception, Message> exceptions = new HashMap<Exception, Message>();

	public HttpCallContext(String url) {this.url = url;}

	public HttpCallContext()
	{
		this.timestamp = new Date(System.currentTimeMillis());
	}

	public static class Message
	{
		public Exception exception;

		public List<StackTraceElement> list;

		public HashMap<Exception, Message> exceptions = new HashMap<Exception, Message>();

		public Message(Exception exception, StackTraceElement[] list)
		{
			this.exception = exception;

			this.list = Arrays.asList(list);
		}

		public Message(Exception exception, List<StackTraceElement> list)
		{
			this.exception = exception;

			this.list = list;
		}
	}
}
