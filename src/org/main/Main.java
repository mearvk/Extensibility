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
			new SystemPublishment(0, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part000("{branch name}")), new SystemPublishment.SystemPartParametry(0, 0x001,"//documents/document-000.xml"), new SystemContext.SamRegistry("//documents/registry-000.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(1, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part001("{firewall}")), new SystemPublishment.SystemPartParametry(1, 0x001,"//documents/document-001.xml"), new SystemContext.SamRegistry("//documents/registry-001.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(2, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part002("{authentication}")), new SystemPublishment.SystemPartParametry(2,0x001,"//documents/document-002.xml"), new SystemContext.SamRegistry("//documents/registry-002.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(3, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part003("{packet inspection}")), new SystemPublishment.SystemPartParametry(3,0x001,"//documents/document-003.xml"), new SystemContext.SamRegistry("//documents/registry-003.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(4, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part004("{dns/ip/port logging}")), new SystemPublishment.SystemPartParametry(4,0x001,"//documents/document-004.xml"), new SystemContext.SamRegistry("//documents/registry-004.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(5, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part005("{exception logging}")), new SystemPublishment.SystemPartParametry(5,0x001,"//documents/document-005.xml"), new SystemContext.SamRegistry("//documents/registry-005.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(6, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part006("{parser}")), new SystemPublishment.SystemPartParametry(6,0x001,"//documents/document-006.xml"), new SystemContext.SamRegistry("//documents/registry-006.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(7, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part007("{file handler}")), new SystemPublishment.SystemPartParametry(7,0x001,"//documents/document-007.xml"), new SystemContext.SamRegistry("//documents/registry-007.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment(8, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part008("{output handler}")), new SystemPublishment.SystemPartParametry(8,0x001,"//documents/document-008.xml"), new SystemContext.SamRegistry("//documents/registry-008.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
		 	new SystemPublishment(9, new SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part009("{exception logging}")), new SystemPublishment.SystemPartParametry(9,0x001,"//documents/document-009.xml"), new SystemContext.SamRegistry("//documents/registry-009.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}"))
		);
	}
}