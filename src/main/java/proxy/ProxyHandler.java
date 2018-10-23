package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    private Object proxied;

    public ProxyHandler(Object target) {
        proxied = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call dosomething()");
        return method.invoke(proxied, args);
    }

}
