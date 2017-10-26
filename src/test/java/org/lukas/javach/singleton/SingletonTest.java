package org.lukas.javach.singleton;

import org.hamcrest.core.IsSame;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Lukas on 25.10.2017.
 *
 * @author Lukas Pecak
 */
public class SingletonTest {

    private static final int NUMBER_OF_TASKS = 10000;
    private static Logger log = LoggerFactory.getLogger(SingletonTest.class);

    private ExecutorService executorService;

    @Before
    public void initialize() {
        executorService = Executors.newFixedThreadPool(NUMBER_OF_TASKS);
    }

    @Test
    public void testThreadSaveEagerSingletonClassForSingletonProperty() throws ExecutionException, InterruptedException {
        testSingletonProperty(ThreadSaveEagerSingleton.getInstance(), this::generateThreadEagerTask);
    }

    @Test
    public void testLazySynchronizedSingletonClassForSingletonProperty() throws ExecutionException, InterruptedException {
        testSingletonProperty(LazySynchronizedSingleton.getInstance(), this::generateThreadLazySynchronizedTask);
    }

    @Test
    public void testDoubleCheckedLockingClassForSingletonProperty() throws ExecutionException, InterruptedException {
        testSingletonProperty(DoubleCheckedLockingSingleton.getInstance(), this::generateDoubleCheckedLockingTask);
    }

    @Test
    public void testStaticInnerClassSingletonForSingletonProperty() throws ExecutionException, InterruptedException {
        testSingletonProperty(StaticInnerClassSingleton.getInstance(), this::generateStaticInnerClassTask);
    }

    private Callable<ThreadSaveEagerSingleton> generateThreadEagerTask() {
        return ThreadSaveEagerSingleton::getInstance;
    }

    private Callable<LazySynchronizedSingleton> generateThreadLazySynchronizedTask() {
        return LazySynchronizedSingleton::getInstance;
    }

    private Callable<DoubleCheckedLockingSingleton> generateDoubleCheckedLockingTask() {
        return DoubleCheckedLockingSingleton::getInstance;
    }

    private Callable<StaticInnerClassSingleton> generateStaticInnerClassTask() {
        return StaticInnerClassSingleton::getInstance;
    }

    private <T> void testSingletonProperty(T instance, Supplier<Callable<T>> taskFactory) throws InterruptedException, ExecutionException {
        String className = instance.getClass().getSimpleName();
        log.info(String.format("Running singleton property check test method for %s class", className));

        Collection<Callable<T>> tasks = Stream.generate(taskFactory).limit(NUMBER_OF_TASKS).collect(Collectors.toList());
        Collection<Future<T>> results;
        try {
            results = executorService.invokeAll(tasks);
        } catch (InterruptedException exception) {
            results = Collections.emptyList();
            log.error("Current thread interrupted", exception);
        }
        for (Future<T> future : results) {
            assertThat(instance, IsSame.theInstance(future.get()));
        }
        log.info(String.format("The single property pattern is fulfilled for %d threads in the %s class", results.size(), className));
    }
}