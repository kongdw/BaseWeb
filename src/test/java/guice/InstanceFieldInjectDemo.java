package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * 属性注入方式2
 * @author David Kong
 * @version 1.0
 */
public class InstanceFieldInjectDemo {

    @Inject
    private Service service;

    public static void main(String[] args) {

        final InstanceFieldInjectDemo demo = new InstanceFieldInjectDemo();
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestInjection(demo);
            }
        });
        demo.service.execute();

        final InstanceFieldInjectDemo demo2 = new InstanceFieldInjectDemo();
        Guice.createInjector().injectMembers(demo2);
        demo2.service.execute();
    }

}
