package org.main;

import org.system.SystemContext;
import org.system.SystemContext.SystemContextStructure;
import org.system.SystemContextContainer;
import org.system.ordenments.OrderedContext;
import org.system.ordenments.OrderedParts;
import org.system.ordenments.containers.OrdenmentContextContainer;
import org.system.publishment.PublishmentContext;
import org.system.publishment.SystemPublishment;

public class Main
{
	public static void main(String... args)
	{

		SystemContextContainer syscontext = new SystemContextContainer
		(
			new SystemContext
			(
				new SystemContext.Username("jndi", "mearvk.us", "{username}"),
				new SystemContext.Password("jndi", "mearvk.us", "{password}"),
				new SystemContext.SystemHTTPServer("www.mearvk.us","http-server", 39998),
				new SystemContext.SystemContextChangeListener("www.mearvk.org","change-context-listener", 40000),
				new SystemContext.SystemContextInitializer("dynamic"),
				new SystemContextStructure("www.mearvk.org","system/servers","http-server"),
				new SystemContext.RemoteSystemPublishmentContext("GET", "{program-part-number}/{base-name}/{branch-name}/publishments", "http-server-parametry")
			),

			new SystemContext
			(
				new SystemContext.Username("jndi", "mearvk.us", "{username}"),
				new SystemContext.Password("jndi", "mearvk.us", "{password}"),
				new SystemContext.SystemHTTPServer("www.mearvk.us","http-server", 39998),
				new SystemContext.SystemContextChangeListener("www.mearvk.org","change-context-listener", 40000),
				new SystemContext.SystemContextInitializer("dynamic"),
				new SystemContextStructure("www.mearvk.org","system/servers","jndi-server"),
				new SystemContext.RemoteSystemPublishmentContext("GET", "{program-part-number}/{base-name}/{branch-name}/publishments", "http-server-parametry")
			)
		);


		OrdenmentContextContainer ordcontext = new OrdenmentContextContainer
		(
			new OrderedContext
			(
				new SystemContext.SystemPublishmentContext("http-server", "mearvk.us", "federal"),
				new OrderedParts("0x0000-0000-0001", "housing.mearvk.us", "mearvk.us", "{names}/{modest}"),
				new OrderedParts("0x0000-0000-0002", "housing.mearvk.us", "mearvk.us", "{firewalls}/{modest}"),
				new OrderedParts("0x0000-0000-0003", "housing.mearvk.us", "mearvk.us", "{authentication}/{modest}"),
				new OrderedParts("0x0000-0000-0004", "housing.mearvk.us", "mearvk.us", "{packet-inspection}/{modest}"),
				new OrderedParts("0x0000-0000-0005", "housing.mearvk.us", "mearvk.us", "{logging}/{modest}"),
				new OrderedParts("0x0000-0000-0006", "housing.mearvk.us", "mearvk.us", "{exceptions}/{modest}"),
				new OrderedParts("0x0000-0000-0007", "housing.mearvk.us", "mearvk.us", "{parser}/{modest}"),
				new OrderedParts("0x0000-0000-0008", "housing.mearvk.us", "mearvk.us", "{file-io}/{modest}"),
				new OrderedParts("0x0000-0000-0009", "housing.mearvk.us", "mearvk.us", "{output-io}/{modest}")
			),

			new OrderedContext
			(
				new SystemContext.SystemPublishmentContext("jndi-server", "mearvk.us", "federal"),
				new OrderedParts("0x0000-0000-0001", "housing.mearvk.us", "mearvk.us", "{names}/{modest}"),
				new OrderedParts("0x0000-0000-0002", "housing.mearvk.us", "mearvk.us", "{firewalls}/{modest}"),
				new OrderedParts("0x0000-0000-0003", "housing.mearvk.us", "mearvk.us", "{authentication}/{modest}"),
				new OrderedParts("0x0000-0000-0004", "housing.mearvk.us", "mearvk.us", "{packet-inspection}/{modest}"),
				new OrderedParts("0x0000-0000-0005", "housing.mearvk.us", "mearvk.us", "{logging}/{modest}"),
				new OrderedParts("0x0000-0000-0006", "housing.mearvk.us", "mearvk.us", "{exceptions}/{modest}"),
				new OrderedParts("0x0000-0000-0007", "housing.mearvk.us", "mearvk.us", "{parser}/{modest}"),
				new OrderedParts("0x0000-0000-0008", "housing.mearvk.us", "mearvk.us", "{file-io}/{modest}"),
				new OrderedParts("0x0000-0000-0009", "housing.mearvk.us", "mearvk.us", "{output-io}/{modest}")
			)
		);

		PublishmentContext publishment = new PublishmentContext
		(
			new SystemContext.SystemHTTPServer("mearvk.us","http-publishment-server", 19998),
			new SystemContext.SystemHTTPServer.Messaging.Publishment("POST", "{program-name}/publishments", "http-server-parametry"),
			new SystemPublishment.SystemPartParametry(0x00001, 0x00001,"//documents/document-000.xml", new SystemContext.SamRegistry("//documents/registry-000.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00002, 0x00001,"//documents/document-001.xml", new SystemContext.SamRegistry("//documents/registry-001.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00003, 0x00001,"//documents/document-002.xml", new SystemContext.SamRegistry("//documents/registry-002.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00004, 0x00001,"//documents/document-003.xml", new SystemContext.SamRegistry("//documents/registry-003.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00005, 0x00001,"//documents/document-004.xml", new SystemContext.SamRegistry("//documents/registry-004.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00006, 0x00001,"//documents/document-005.xml", new SystemContext.SamRegistry("//documents/registry-005.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00007, 0x00001,"//documents/document-006.xml", new SystemContext.SamRegistry("//documents/registry-006.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00008, 0x00001,"//documents/document-007.xml", new SystemContext.SamRegistry("//documents/registry-007.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}")),
			new SystemPublishment.SystemPartParametry(0x00009, 0x00001,"//documents/document-008.xml", new SystemContext.SamRegistry("//documents/registry-008.xml"), new SystemContext.Username("jndi", "mearvk.us", "{username}"), new SystemContext.Password("jndi", "mearvk.us", "{password}"))
		);
	}
}