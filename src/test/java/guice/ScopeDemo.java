package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * 作用域
 * @author David Kong
 * @version 1.0
 */
public class ScopeDemo {
    public static void main(String[] args) {
        Service service = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).to(WwwService.class).in(Scopes.SINGLETON);
            }
        }).getInstance(Service.class);
        service.execute();
    }
}
