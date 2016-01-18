package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * @author David Kong
 * @version 1.0
 */
public class StaticMultiInterfaceServiceDemo {

    @Inject
    @Www
    private static Service wwwService;

    @Inject
    @Home
    private static Service homeService;

    public static void main(String[] args) {
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(Www.class).to(WwwService.class);
                binder.bind(Service.class).annotatedWith(Home.class).to(HomeService.class);
                binder.requestStaticInjection(StaticMultiInterfaceServiceDemo.class);
            }
        });
        StaticMultiInterfaceServiceDemo.homeService.execute();
        StaticMultiInterfaceServiceDemo.wwwService.execute();
    }

}
