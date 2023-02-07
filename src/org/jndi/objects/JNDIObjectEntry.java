package org.jndi.objects;

import java.rmi.Remote;

public class JNDIObjectEntry implements Remote
{
    public String host;

    public String project;

    public String base;

    public String namespace;

    public String name;
    @Override
    public String toString()
    {
        return namespace+"."+name;
    }
}
