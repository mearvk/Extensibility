package org.main;

import org.system.SystemContext;
import org.system.rmi.RMISystemContext;

public class Main
{
	public static void main(String... args)
	{
		SystemContext context = new SystemContext
		(
			new SystemContext.Username("jndi", "mearvk.us", "{username}"),
			new SystemContext.Password("jndi", "mearvk.us", "{password}"),
			new SystemContext.SystemHTTPServer("www.mearvk.org","http-server", 39998),
			new SystemContext.SystemContextChangeListener("www.mearvk.org","change-context-listener", 40000),
			new SystemContext.SystemContextInitializer("dynamic"),
			new SystemContext.SystemContextStructure("www.mearvk.org","system/servers","http-server"),
			new SystemContext.SystemPublishment(1, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part001("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document-001.xml"), new SystemContext.SamRegistry("//documents/registry-001.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(2, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part002("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(2,1,"//documents/document-002.xml"), new SystemContext.SamRegistry("//documents/registry-002.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(3, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part003("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(3,1,"//documents/document-003.xml"), new SystemContext.SamRegistry("//documents/registry-003.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(4, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part004("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(4,1,"//documents/document-004.xml"), new SystemContext.SamRegistry("//documents/registry-004.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(5, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part005("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(5,1,"//documents/document-005.xml"), new SystemContext.SamRegistry("//documents/registry-005.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(6, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part006("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(6,1,"//documents/document-006.xml"), new SystemContext.SamRegistry("//documents/registry-006.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(7, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part007("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(7,1,"//documents/document-007.xml"), new SystemContext.SamRegistry("//documents/registry-007.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(8, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part008("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(8,1,"//documents/document-008.xml"), new SystemContext.SamRegistry("//documents/registry-008.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}"))
		);
	}
}