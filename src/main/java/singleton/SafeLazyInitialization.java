package singleton;

public class SafeLazyInitialization {
    private static SafeLazyInitialization instance;

    private SafeLazyInitialization() {

    }

    public synchronized static SafeLazyInitialization getInstance() {
        if (instance == null) {
            instance = new SafeLazyInitialization();
        }
        return instance;
    }
}
