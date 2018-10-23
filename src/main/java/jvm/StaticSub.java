package jvm;

/**
 * Created by chuan on 2018/6/17.
 */
public class StaticSub extends StaticF{
    static {
        System.out.println("StaticSubstatic");
    }
    public static void sayHello(){
        System.out.println("StaticSub");
    }
    public static void main(String[] args){
        StaticSub.sayHello();
    }
}
