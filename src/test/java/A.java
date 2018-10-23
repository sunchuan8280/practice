
public abstract class A {
    public abstract void a();

    public synchronized void b() {
        a();
        System.out.println("A---b");
    }

}
