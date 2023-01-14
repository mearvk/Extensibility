package org.system.publishment.containers;

import org.system.SystemContext;

import java.io.File;

public class SystemPublishmentContainer
{
	public SystemPublishmentContainer(Integer order, SystemPublishmentContainer.SystemPart part)
	{

	}

	public SystemPublishmentContainer(Integer order, SystemPublishmentContainer.SystemPart part, SystemPublishmentContainer.SystemPartParametry parametry, SystemContext.SamRegistry samregistry, SystemContext.Username username, SystemContext.Password password)
	{

	}

	public SystemPublishmentContainer(Integer order, SystemPublishmentContainer.SystemPart part, SystemPublishmentContainer.SystemPartParametry parametry, SystemContext.Username username, SystemContext.Password password)
	{

	}
	public SystemPublishmentContainer(Integer order, SystemPublishmentContainer.SystemPart part, SystemPublishmentContainer.SystemPartParametry parametry)
	{

	}

	public static class SystemPart
	{
		public SystemPart()
		{

		}

		public SystemPart(Object object)
		{

		}

		public SystemPart(Class klass)
		{

		}
	}

	public static class SystemPartParametry
	{
		public Integer partnumber;

		public Integer commonpartnumber;

		public String document;

		public File file;

		public SystemPartParametry(Integer part_number, Integer common_part_number, String document, SystemContext.SamRegistry sam_registry, SystemContext.Username username, SystemContext.Password password)
		{
			this.partnumber = part_number;

			this.commonpartnumber = common_part_number;

			this.document = document;
		}
	}
}