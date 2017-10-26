package org.lukas.javach.singleton;

/**
 * Created by Lukas on 25.10.2017.
 *
 * @author Lukas Pecak
 */
class LazySynchronizedSingleton {

    private static LazySynchronizedSingleton instance;

    private LazySynchronizedSingleton() {}

    static synchronized LazySynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new LazySynchronizedSingleton();
        }
        return instance;
    }

}
