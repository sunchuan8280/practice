package rmi;

import java.lang.String;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chuan on 2018/11/25.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {
    private Map<String,Double> prices;

    public WarehouseImpl() throws RemoteException{
        prices=new HashMap<>();
        prices.put("black",24.95);
        prices.put("white",49.95);
    }

    public double getPrice(String description) throws RemoteException{
        Double price =prices.get(description);
        return price==null?0:price;
    }


}
