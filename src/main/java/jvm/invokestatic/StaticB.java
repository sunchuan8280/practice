package jvm.invokestatic;

/**
 * Created by chuan on 2018/9/1.
 */
public class StaticB extends StaticA{
        public static String v ="this is son variable";
        public void method1(){
            System.out.println("this is son non-static method1");
        }
        public static void method2(){
            System.out.println("this is son static method2");
        }

      public static void main(String[] args){
          StaticA s1=new StaticA();
          StaticB s2=new StaticB();
          StaticA s3=new StaticB();

          s3.method1();
          s3.method2();


        }
}

