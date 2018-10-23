package singleton;

public class SafeDoubleCheckedLocking {
    private volatile static SafeDoubleCheckedLocking instance;

    private SafeDoubleCheckedLocking() {

    }

    public static SafeDoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new SafeDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

}
