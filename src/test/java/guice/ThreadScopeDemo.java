package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Scope;

import java.util.concurrent.TimeUnit;

/**
 * 线程作用域的scope demo
 *
 * @author David Kong
 * @version 1.0
 */
public class ThreadScopeDemo {

    static class ThreadScope implements Scope {

        static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

        @Override
        public <T> Provider<T> scope(Key<T> key, final Provider<T> unscoped) {
            return new Provider<T>() {
                @Override
                public T get() {
                    T instance = (T) threadLocal.get();
                    if (instance == null) {
                        instance = unscoped.get();
                        threadLocal.set(instance);
                    }
                    return instance;
                }
            };
        }
    }

    @Override
    public String toString() {
        return "Scopes.ThreadServiceScope";
    }

    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).to(HomeService.class).in(new ThreadScope());
            }
        });

        for (int i = 0; i < 3; i++) {
            new Thread("Thread-" + i) {
                public void run() {
                    for (int m = 0; m < 3; m++) {
                        System.out.println(String.format("%s-%d:%d", getName(), m, injector.getInstance(Service.class).hashCode()));
                        try {
                            TimeUnit.SECONDS.sleep(10l);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }.start();
        }
    }

}
