package guice.aop;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * @author David Kong
 * @version 1.0
 */
public class AopDemo {
    @Inject
    private Service service;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bindInterceptor(Matchers.any(),Matchers.annotatedWith(Names.named("log")),new LoggerMethodInterceptor());
            }
        });
        injector.getInstance(AopDemo.class).service.sayHello();
        injector.getInstance(AopDemo.class).service.sayHello();
        injector.getInstance(AopDemo.class).service.sayHello();
    }
}
