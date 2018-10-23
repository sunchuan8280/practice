package proxy;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class DynamicProxy {
    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[] { Subject.class }, new ProxyHandler(real));
        proxySubject.dosomething();
        createProxyClassFile();

    }

    public static void createProxyClassFile() {
        String name = "ProxySubject";

        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });

        try {
            FileOutputStream out = new FileOutputStream(
                    "D:\\develop\\workspace\\practice-sample\\target\\" + name + ".class");
            out.write(data);
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
