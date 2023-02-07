package org.jndi;

import org.jndi.objects.JNDIObjectEntry;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JNDIServer
{
    public String host = "localhost";

    public Integer port = 55555;

    public Registry registry = null;

    public JNDIServer(String host, Integer port)
    {
        this.host = host;

        this.port = port;

        try
        {
            this.registry = LocateRegistry.getRegistry(this.host, this.port);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public JNDIServer()
    {
        try
        {
            this.registry = LocateRegistry.getRegistry(this.host, this.port);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void add(String namespace, String name, JNDIObjectEntry object) throws NotBoundException
    {
        try
        {
            if(this.registry.lookup("*")==null)
            {
                throw new NotBoundException();
            }

            if(!namespace.equals(object.namespace))
            {
                throw new NotBoundException();
            }

            if(!name.equals(object.name))
            {
                throw new NotBoundException();
            }

            this.registry.bind(object.toString(), object);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void remove(String namespace, String name) throws NotBoundException, NoSuchObjectException
    {
        try
        {
            if(this.registry.lookup("*")==null)
            {
                throw new NotBoundException();
            }

            this.registry.unbind(namespace+"."+name);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static class NotBoundException extends Exception
    {

    }

    public static class NoSuchObjectException extends Exception
    {

    }
}
