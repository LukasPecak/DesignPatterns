package org.lukas.javach.singleton;

/**
 * Created by Lukas on 26.10.2017.
 *
 * @author Lukas Pecak
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){}

    private static class SingletonHolder {

        private SingletonHolder(){}

        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
