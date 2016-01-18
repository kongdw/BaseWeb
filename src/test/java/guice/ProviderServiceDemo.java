package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * @author David Kong
 * @version 1.0
 */
public class ProviderServiceDemo {

    @Inject
    private Service service;

    @Inject
    private Provider<Service> provider;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).toProvider(WwwServiceProvider.class);
            }
        });
        ProviderServiceDemo demo = injector.getInstance(ProviderServiceDemo.class);
        demo.service.execute();

        ProviderServiceDemo demo2 = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).toProvider(HomeServiceProvider.class);
            }
        }).getInstance(ProviderServiceDemo.class);
        demo2.provider.get().execute();
    }

}
