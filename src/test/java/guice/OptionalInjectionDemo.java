package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * 选项注入
 * 如果不能从guice容器中获取到一个对象，那么可以使用一个默认的对象
 * @author David Kong
 * @version 1.0
 */
public class OptionalInjectionDemo {

    @Inject
    private Service service = new WwwService();

    public static void main(String[] args) {
        OptionalInjectionDemo demo =  Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                //binder.bind(Service.class).to(HomeService.class);
            }
        }).getInstance(OptionalInjectionDemo.class);
        demo.service.execute();
    }
}
