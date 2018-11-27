package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Created by chuan on 2018/11/25.
 */
public class WarehouseServer {
    public static void main(String[] args) throws RemoteException,NamingException{
        System.out.println("Constructing server implementation....");
        WarehouseImpl centralWarehouse=new WarehouseImpl();
        System.out.println("Binding server implementation to registry...");
        Context namingContext=new InitialContext();
        namingContext.bind("rmi:central_Warehouse",centralWarehouse);
        System.out.println("Waiting for invocation from clients...");
    }
}
