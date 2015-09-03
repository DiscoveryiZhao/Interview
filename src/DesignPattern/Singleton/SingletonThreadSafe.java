package DesignPattern.Singleton;

/**
 * Reference: http://crunchify.com/thread-safe-and-a-fast-singleton-implementation-in-java/
 */
public class SingletonThreadSafe {
    private static SingletonThreadSafe instance = null;

    protected SingletonThreadSafe() {
    }

    // Lazy Initialization (If required then only)
    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}
