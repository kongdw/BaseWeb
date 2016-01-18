package guice.aop;

import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author David Kong
 * @version 1.0
 */
@Singleton
public class ServiceImpl implements Service {

    @Override
    @Named("log")
    public void sayHello() {
        System.out.println(String.format("[%s#%d] execute %s at %d", this.getClass().getSimpleName(), hashCode(), "sayHello", System.nanoTime()));
    }
}
