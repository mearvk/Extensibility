package org.main;

import org.system.SystemContext;
import org.system.SystemContext.SystemContextStructure;
import org.system.publishment.PublishmentContext;
import org.system.publishment.SystemPublishment;

public class Main
{
	PublishmentContext publishment;

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

		PublishmentContext publishment = new PublishmentContext
		(
			new SystemContext.SystemHTTPServer("mearvk.us","http-publishment-server", 19998),
			new SystemContext.SystemHTTPServer.Messaging.Publishment("POST", "{program-name}/publishments", "http-server-parametry"),
			new SystemPublishment(0x1, new SystemPublishment.SystemPart(new org.system.servers.http.system.System("{branch name}")), new SystemPublishment.SystemPartParametry(0, 0x001,"//documents/document-000.xml"), new SystemContext.SamRegistry("//documents/registry-000.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x2, new SystemPublishment.SystemPart(new org.system.servers.http.firewall.Firewall("{firewall}")), new SystemPublishment.SystemPartParametry(1, 0x001,"//documents/document-001.xml"), new SystemContext.SamRegistry("//documents/registry-001.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x3, new SystemPublishment.SystemPart(new org.system.servers.http.authentication.Authenticator("{authentication}")), new SystemPublishment.SystemPartParametry(2,0x001,"//documents/document-002.xml"), new SystemContext.SamRegistry("//documents/registry-002.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x4, new SystemPublishment.SystemPart(new org.system.servers.http.inspection.PacketInspector("{packet inspection}")), new SystemPublishment.SystemPartParametry(3,0x001,"//documents/document-003.xml"), new SystemContext.SamRegistry("//documents/registry-003.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x5, new SystemPublishment.SystemPart(new org.system.servers.http.logging.Logging("{dns/ip/port logging}")), new SystemPublishment.SystemPartParametry(4,0x001,"//documents/document-004.xml"), new SystemContext.SamRegistry("//documents/registry-004.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x6, new SystemPublishment.SystemPart(new org.system.servers.http.exceptions.Exception("{exception logging}")), new SystemPublishment.SystemPartParametry(5,0x001,"//documents/document-005.xml"), new SystemContext.SamRegistry("//documents/registry-005.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x7, new SystemPublishment.SystemPart(new org.system.servers.http.parsing.Parser("{parser}")), new SystemPublishment.SystemPartParametry(6,0x001,"//documents/document-006.xml"), new SystemContext.SamRegistry("//documents/registry-006.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x8, new SystemPublishment.SystemPart(new org.system.servers.http.nio.FileHandler("{file handler}")), new SystemPublishment.SystemPartParametry(7,0x001,"//documents/document-007.xml"), new SystemContext.SamRegistry("//documents/registry-007.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(0x9, new SystemPublishment.SystemPart(new org.system.servers.http.output.OutputHandler("{output handler}")), new SystemPublishment.SystemPartParametry(8,0x001,"//documents/document-008.xml"), new SystemContext.SamRegistry("//documents/registry-008.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}"))
		);
	}
}