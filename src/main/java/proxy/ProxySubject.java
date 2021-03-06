package proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import proxy.Subject;

public final class ProxySubject extends Proxy implements Subject {

   private static Method m1;
   private static Method m2;
   private static Method m3;
   private static Method m0;


   public ProxySubject(InvocationHandler var1)   {
      super(var1);
   }

   public final boolean equals(Object var1)   {
      try {
         return ((Boolean)super.h.invoke(this, m1, new Object[]{var1})).booleanValue();
      } catch (RuntimeException e) {
         throw e;
      } catch (Throwable var4) {
         throw new UndeclaredThrowableException(var4);
      }
   }

   public final String toString()   {
      try {
         return (String)super.h.invoke(this, m2, (Object[])null);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Throwable var3) {
         throw new UndeclaredThrowableException(var3);
      }
   }

   public final void dosomething()   {
      try {
         super.h.invoke(this, m3, (Object[])null);
      } catch (RuntimeException  var2) {
         throw var2;
      } catch (Throwable var3) {
         throw new UndeclaredThrowableException(var3);
      }
   }

   public final int hashCode()   {
      try {
         return ((Integer)super.h.invoke(this, m0, (Object[])null)).intValue();
      } catch (RuntimeException  var2) {
         throw var2;
      } catch (Throwable var3) {
         throw new UndeclaredThrowableException(var3);
      }
   }

   static {
      try {
         m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
         m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
         m3 = Class.forName("proxy.Subject").getMethod("dosomething", new Class[0]);
         m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
      } catch (NoSuchMethodException var2) {
         throw new NoSuchMethodError(var2.getMessage());
      } catch (ClassNotFoundException var3) {
         throw new NoClassDefFoundError(var3.getMessage());
      }
   }
}