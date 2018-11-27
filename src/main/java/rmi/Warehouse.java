package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.lang.String;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by chuan on 2018/11/25.
 */
public interface Warehouse extends Remote {
    double getPrice(String description) throws RemoteException;
}
