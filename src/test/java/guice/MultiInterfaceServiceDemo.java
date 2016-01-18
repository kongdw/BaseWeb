package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 *
 * 使用注解注入对象
 * @author David Kong
 * @version 1.0
 */
public class MultiInterfaceServiceDemo {

    @Inject
    @Www
    private Service wwwService;

    @Inject
    @Home
    private Service homeService;

    public static void main(String[] args) {
        MultiInterfaceServiceDemo demo = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(Www.class).to(WwwService.class);
                binder.bind(Service.class).annotatedWith(Home.class).to(HomeService.class);
            }
        }).getInstance(MultiInterfaceServiceDemo.class);
        demo.homeService.execute();
        demo.wwwService.execute();
    }
}
