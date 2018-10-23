package singleton;

public class UnsafeLazyInitialization {
    private static UnsafeLazyInitialization instance;

    private UnsafeLazyInitialization() {

    }

    public static UnsafeLazyInitialization getInstance() {
        if (instance == null) {
            instance = new UnsafeLazyInitialization();
        }
        return instance;
    }
}
