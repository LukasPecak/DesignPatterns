package org.lukas.javach.singleton;

/**
 * Created by Lukas on 25.10.2017.
 *
 * @author Lukas Pecak
 */
class ThreadSaveEagerSingleton {

    private static final ThreadSaveEagerSingleton instance = new ThreadSaveEagerSingleton();

    private ThreadSaveEagerSingleton() {
    }

    static ThreadSaveEagerSingleton getInstance() {
        return instance;
    }

}
