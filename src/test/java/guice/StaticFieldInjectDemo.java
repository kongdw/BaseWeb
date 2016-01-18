package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 *
 * 静态属性注入
 * @author David Kong
 * @version 1.0
 */
public class StaticFieldInjectDemo {

    @Inject
    private static Service service;

    public static void main(String[] args) {
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestStaticInjection(StaticFieldInjectDemo.class);
            }
        });
        StaticFieldInjectDemo.service.execute();
    }
}
