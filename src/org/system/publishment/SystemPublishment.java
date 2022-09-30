package org.system.publishment;

import org.system.SystemContext;

import java.io.File;

public class SystemPublishment
{
	public SystemPublishment(Integer order, SystemPublishment.SystemPart part)
	{

	}

	public SystemPublishment(Integer order, SystemPublishment.SystemPart part, SystemPublishment.SystemPartParametry parametry, SystemContext.SamRegistry samregistry, SystemContext.Username username, SystemContext.Password password)
	{

	}

	public SystemPublishment(Integer order, SystemPublishment.SystemPart part, SystemPublishment.SystemPartParametry parametry, SystemContext.Username username, SystemContext.Password password)
	{

	}
	public SystemPublishment(Integer order, SystemPublishment.SystemPart part, SystemPublishment.SystemPartParametry parametry)
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

		public SystemPartParametry(Integer part_number, Integer common_part_number, String document)
		{
			this.partnumber = part_number;

			this.commonpartnumber = common_part_number;

			this.document = document;
		}
	}
}