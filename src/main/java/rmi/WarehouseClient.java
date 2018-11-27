package rmi;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.lang.String;
/**
 * Created by chuan on 2018/11/25.
 */
public class WarehouseClient  {
    public static void main(String[] args) throws RemoteException,NamingException {
        Context namingContext =new InitialContext();
        System.out.println("RMI registry bindings:");
        Enumeration<NameClassPair> enumeration = namingContext.list("rmi://localhost/");
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement().getName());
        }
        String url="rmi://localhost/central_warehouse";
        Warehouse centralWarehouse=(Warehouse)namingContext.lookup(url);
        String descr="black";
        double price=centralWarehouse.getPrice(descr);
        System.out.println("price:"+price);
    }
}
