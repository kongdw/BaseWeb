package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * @author David Kong
 * @version 1.0
 */
public class NoAnnotationMultiInterfaceServiceDemo {

    @Inject
    @Named("www")
    private static Service wwwService;
    @Inject
    @Named("home")
    private static Service homeService;

    public static void main(String[] args) {
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(Names.named("www")).to(WwwService.class);
                binder.bind(Service.class).annotatedWith(Names.named("home")).to(HomeService.class);
                binder.requestStaticInjection(NoAnnotationMultiInterfaceServiceDemo.class);
            }
        });
        NoAnnotationMultiInterfaceServiceDemo.homeService.execute();
        NoAnnotationMultiInterfaceServiceDemo.wwwService.execute();
    }
}
