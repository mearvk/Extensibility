package org.main;

import org.system.SystemContext;
import org.system.SystemContext.SystemContextStructure;
import org.system.ordenments.OrdenmentContext;
import org.system.ordenments.OrdenmentPublishment;
import org.system.publishment.PublishmentContext;
import org.system.publishment.SystemPublishment;

public class Main
{
	public static void main(String... args)
	{
		SystemContext context = new SystemContext
		(
			new SystemContext.Username("jndi", "mearvk.us", "{username}"),
			new SystemContext.Password("jndi", "mearvk.us", "{password}"),
			new SystemContext.SystemHTTPServer("www.mearvk.us","http-server", 39998),
			new SystemContext.SystemContextChangeListener("www.mearvk.org","change-context-listener", 40000),
			new SystemContext.SystemContextInitializer("dynamic"),
			new SystemContextStructure("www.mearvk.org","system/servers","http-server"),
			new SystemContext.RemoteSystemPublishmentContext("GET", "{program-name}/publishments", "http-server-parametry")
		);

		OrdenmentContext ordenment = new OrdenmentContext
		(
			new OrdenmentPublishment(0x0001, new org.system.servers.http.system.System("{branch name}")),
			new OrdenmentPublishment(0x0002, new org.system.servers.http.firewall.Firewall("{firewall}")),
			new OrdenmentPublishment(0x0003, new org.system.servers.http.authentication.Authenticator("{authentication}")),
			new OrdenmentPublishment(0x0004, new org.system.servers.http.inspection.PacketInspector("{packet inspection}")),
			new OrdenmentPublishment(0x0005, new org.system.servers.http.logging.Logging("{dns/ip/port logging}")),
			new OrdenmentPublishment(0x0006, new org.system.servers.http.exceptions.Exception("{exception logging}")),
			new OrdenmentPublishment(0x0007, new org.system.servers.http.parsing.Parser("{parser}")),
			new OrdenmentPublishment(0x0008, new org.system.servers.http.nio.FileHandler("{file handler}")),
			new OrdenmentPublishment(0x0009, new org.system.servers.http.output.OutputHandler("{output handler}"))
		);

		PublishmentContext publishment = new PublishmentContext
		(
			new SystemContext.SystemHTTPServer("mearvk.us","http-publishment-server", 19998),
			new SystemContext.SystemHTTPServer.Messaging.Publishment("POST", "{program-name}/publishments", "http-server-parametry"),
			new SystemPublishment.SystemPartParametry(0x0001, 0x0001,"//documents/document-000.xml", new SystemContext.SamRegistry("//documents/registry-000.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0002, 0x0001,"//documents/document-001.xml", new SystemContext.SamRegistry("//documents/registry-001.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0003,0x0001,"//documents/document-002.xml", new SystemContext.SamRegistry("//documents/registry-002.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0004,0x0001,"//documents/document-003.xml", new SystemContext.SamRegistry("//documents/registry-003.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0005,0x0001,"//documents/document-004.xml", new SystemContext.SamRegistry("//documents/registry-004.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0006,0x0001,"//documents/document-005.xml", new SystemContext.SamRegistry("//documents/registry-005.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0007,0x0001,"//documents/document-006.xml", new SystemContext.SamRegistry("//documents/registry-006.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0008,0x0001,"//documents/document-007.xml", new SystemContext.SamRegistry("//documents/registry-007.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x0009,0x0001,"//documents/document-008.xml", new SystemContext.SamRegistry("//documents/registry-008.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}"))
		);
	}
}