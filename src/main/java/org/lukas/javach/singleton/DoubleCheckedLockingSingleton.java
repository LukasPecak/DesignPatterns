package org.lukas.javach.singleton;

/**
 * Created by Lukas on 25.10.2017.
 *
 * @author Lukas Pecak
 */
class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    /**
     * This double checked locking can be thread unsafe for mutable singleton classes,
     * After adding the volatile keyword to the filed that holds the instance it is correct
     * @return return the unique instance
     */
    static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
