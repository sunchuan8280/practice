package jvm.invokestatic;

/**
 * Created by chuan on 2018/9/1.
 */
public class StaticA {
    public static String v ="this is father variable";
    public void method1(){
        System.out.println("this is father non-static method1");
    }
    public static void method2(){
        System.out.println("this is father static method2");
    }
}
