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
			new SystemContext.SystemPublishment(0, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part000("{branch name}")), new SystemContext.SystemPublishment.SystemPartParametry(0,0x001,"//documents/document-000.xml"), new SystemContext.SamRegistry("//documents/registry-000.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(1, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part001("{firewall}")), new SystemContext.SystemPublishment.SystemPartParametry(1,0x001,"//documents/document-001.xml"), new SystemContext.SamRegistry("//documents/registry-001.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(2, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part002("{authentication}")), new SystemContext.SystemPublishment.SystemPartParametry(2,0x001,"//documents/document-002.xml"), new SystemContext.SamRegistry("//documents/registry-002.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(3, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part003("{packet inspection}")), new SystemContext.SystemPublishment.SystemPartParametry(3,0x001,"//documents/document-003.xml"), new SystemContext.SamRegistry("//documents/registry-003.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(4, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part004("{dns/ip/port logging}")), new SystemContext.SystemPublishment.SystemPartParametry(4,0x001,"//documents/document-004.xml"), new SystemContext.SamRegistry("//documents/registry-004.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(5, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part005("{exception logging}")), new SystemContext.SystemPublishment.SystemPartParametry(5,0x001,"//documents/document-005.xml"), new SystemContext.SamRegistry("//documents/registry-005.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(6, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part006("{parser}")), new SystemContext.SystemPublishment.SystemPartParametry(6,0x001,"//documents/document-006.xml"), new SystemContext.SamRegistry("//documents/registry-006.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(7, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part007("{file handler}")), new SystemContext.SystemPublishment.SystemPartParametry(7,0x001,"//documents/document-007.xml"), new SystemContext.SamRegistry("//documents/registry-007.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(8, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part008("{output handler}")), new SystemContext.SystemPublishment.SystemPartParametry(8,0x001,"//documents/document-008.xml"), new SystemContext.SamRegistry("//documents/registry-008.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemContext.SystemPublishment(9, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part009("{exception logging}")), new SystemContext.SystemPublishment.SystemPartParametry(9,0x001,"//documents/document-009.xml"), new SystemContext.SamRegistry("//documents/registry-009.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}"))
		);
	}
}