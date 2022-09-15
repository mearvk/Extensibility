package org.main;

import org.system.SystemContext;
import org.system.rmi.RMISystemContext;

public class Main
{
	public static void main(String... args)
	{
		/*

		SystemContext context001 = new SystemContext
		(
			new SystemContext.Username("username"),
			new SystemContext.Password("password"),
			new SystemContext.SystemProgram(new org.system.http.HttpServer(9998)),
			new SystemContext.SystemContextChangeListener("http://www.mearvk.org/system/http-server/listeners/context-listener", 10000),
			new SystemContext.SystemContextInitializer("//dynamic"),
			new SystemContext.SystemContextStructure("//system/servers","//http-server")
		);

		SystemContext context002 = new SystemContext
		(
			new SystemContext.Username("username"),
			new SystemContext.Password("password"),
			new SystemContext.SystemProgram(new org.system.http.HttpServer(19998)),
			new SystemContext.SystemContextChangeListener("http://www.mearvk.org/system/http-server/listeners/context-listener", 20000),
			new SystemContext.SystemContextInitializer("//dynamic"),
			new SystemContext.SystemContextStructure("//system/servers","//http-server"),
			new SystemContext.SystemPublishment(1, new SystemContext.SystemPublishment.SystemPart(), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document001.xml")),
			new SystemContext.SystemPublishment(2, new SystemContext.SystemPublishment.SystemPart(), new SystemContext.SystemPublishment.SystemPartParametry(2,1,"//documents/document002.xml")),
			new SystemContext.SystemPublishment(3, new SystemContext.SystemPublishment.SystemPart(), new SystemContext.SystemPublishment.SystemPartParametry(3,1,"//documents/document003.xml")),
			new SystemContext.SystemPublishment(4, new SystemContext.SystemPublishment.SystemPart(), new SystemContext.SystemPublishment.SystemPartParametry(4,1,"//documents/document004.xml"))
		);

		SystemContext context003 = new SystemContext
		(
			new SystemContext.Username("username"),
			new SystemContext.Password("password"),
			new SystemContext.SystemProgram(new org.system.http.HttpServer(29998)),
			new SystemContext.SystemContextChangeListener("http://www.mearvk.org/system/http-server/listeners/context-listener", 30000),
			new SystemContext.SystemContextInitializer("//dynamic"),
			new SystemContext.SystemContextStructure("//system/servers","//http-server"),
			new SystemContext.SystemPublishment(1, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part001()), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document001.xml")),
			new SystemContext.SystemPublishment(2, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part002()), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document002.xml")),
			new SystemContext.SystemPublishment(3, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part003()), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document003.xml")),
			new SystemContext.SystemPublishment(4, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part004()), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document004.xml")),
			new SystemContext.SystemPublishment(5, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part005()), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document005.xml")),
			new SystemContext.SystemPublishment(6, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part006()), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document006.xml"))
		);

		*/

		SystemContext context004 = new SystemContext
		(
			new SystemContext.Username("username"),
			new SystemContext.Password("password"),
			new SystemContext.SystemHTTPServer("http://www.mearvk.org/system/http-server/listeners/http-context-listener",39998),
			new SystemContext.SystemContextChangeListener("http://www.mearvk.org/system/http-server/listeners/change-context-listener", 40000),
			new SystemContext.SystemContextInitializer("//dynamic"),
			new SystemContext.SystemContextStructure("//system/servers","//http-server"),
			new SystemContext.SystemPublishment(1, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part001()), new SystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document-001.xml"), new SystemContext.SamRegistry("//documents/registry-001.xml"), new SystemContext.Username("username"), new SystemContext.Password("password")),
			new SystemContext.SystemPublishment(2, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part002()), new SystemContext.SystemPublishment.SystemPartParametry(2,1,"//documents/document-002.xml"), new SystemContext.SamRegistry("//documents/registry-002.xml"), new SystemContext.Username("username"), new SystemContext.Password("password")),
			new SystemContext.SystemPublishment(3, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part003()), new SystemContext.SystemPublishment.SystemPartParametry(3,1,"//documents/document-003.xml"), new SystemContext.SamRegistry("//documents/registry-003.xml"), new SystemContext.Username("username"), new SystemContext.Password("password")),
			new SystemContext.SystemPublishment(4, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part004()), new SystemContext.SystemPublishment.SystemPartParametry(4,1,"//documents/document-004.xml"), new SystemContext.SamRegistry("//documents/registry-004.xml"), new SystemContext.Username("username"), new SystemContext.Password("password")),
			new SystemContext.SystemPublishment(5, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part005()), new SystemContext.SystemPublishment.SystemPartParametry(5,1,"//documents/document-005.xml"), new SystemContext.SamRegistry("//documents/registry-005.xml"), new SystemContext.Username("username"), new SystemContext.Password("password")),
			new SystemContext.SystemPublishment(6, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part006()), new SystemContext.SystemPublishment.SystemPartParametry(6,1,"//documents/document-006.xml"), new SystemContext.SamRegistry("//documents/registry-006.xml"), new SystemContext.Username("username"), new SystemContext.Password("password")),
			new SystemContext.SystemPublishment(7, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part007()), new SystemContext.SystemPublishment.SystemPartParametry(7,1,"//documents/document-007.xml"), new SystemContext.SamRegistry("//documents/registry-007.xml"), new SystemContext.Username("username"), new SystemContext.Password("password")),
			new SystemContext.SystemPublishment(8, new SystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part008()), new SystemContext.SystemPublishment.SystemPartParametry(8,1,"//documents/document-008.xml"), new SystemContext.SamRegistry("//documents/registry-008.xml"), new SystemContext.Username("username"), new SystemContext.Password("password"))
		);

		/*

		RMISystemContext context005 = new RMISystemContext
		(
			new RMISystemContext.Username("username"),
			new RMISystemContext.Password("password"),
			new RMISystemContext.SystemProgram(new org.system.http.HttpServer(49998)),
			new RMISystemContext.SystemContextChangeListener("http://www.mearvk.org/system/http-server/listeners/context-listener", 50000),
			new RMISystemContext.SystemContextInitializer("//dynamic"),
			new RMISystemContext.SystemContextStructure("//system/servers","//http-server"),
			new RMISystemContext.SystemPublishment(1, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part001()), new RMISystemContext.SystemPublishment.SystemPartParametry(1,1,"//documents/document-001.xml"), new RMISystemContext.SamRegistry("//documents/registry-001.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password")),
			new RMISystemContext.SystemPublishment(2, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part002()), new RMISystemContext.SystemPublishment.SystemPartParametry(2,1,"//documents/document-002.xml"), new RMISystemContext.SamRegistry("//documents/registry-002.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password")),
			new RMISystemContext.SystemPublishment(3, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part003()), new RMISystemContext.SystemPublishment.SystemPartParametry(3,1,"//documents/document-003.xml"), new RMISystemContext.SamRegistry("//documents/registry-003.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password")),
			new RMISystemContext.SystemPublishment(4, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part004()), new RMISystemContext.SystemPublishment.SystemPartParametry(4,1,"//documents/document-004.xml"), new RMISystemContext.SamRegistry("//documents/registry-004.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password")),
			new RMISystemContext.SystemPublishment(5, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part005()), new RMISystemContext.SystemPublishment.SystemPartParametry(5,1,"//documents/document-005.xml"), new RMISystemContext.SamRegistry("//documents/registry-005.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password")),
			new RMISystemContext.SystemPublishment(6, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part006()), new RMISystemContext.SystemPublishment.SystemPartParametry(6,1,"//documents/document-006.xml"), new RMISystemContext.SamRegistry("//documents/registry-006.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password")),
			new RMISystemContext.SystemPublishment(7, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part007()), new RMISystemContext.SystemPublishment.SystemPartParametry(7,1,"//documents/document-007.xml"), new RMISystemContext.SamRegistry("//documents/registry-007.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password")),
			new RMISystemContext.SystemPublishment(8, new RMISystemContext.SystemPublishment.SystemPart(new org.system.http.partwise.HttpServer.Part008()), new RMISystemContext.SystemPublishment.SystemPartParametry(8,1,"//documents/document-008.xml"), new RMISystemContext.SamRegistry("//documents/registry-008.xml"), new RMISystemContext.Username("username"), new RMISystemContext.Password("password"))
		);

		*/
	}
}