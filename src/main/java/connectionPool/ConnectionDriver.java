package connectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class ConnectionDriver {
    static class ConnectHandler implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] arg) throws InterruptedException {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);

            }
            return null;
        }
    }

    public static final Connection creatConnect() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[] { Connection.class }, new ConnectHandler());
    }
}
