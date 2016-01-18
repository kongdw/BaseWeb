package guice.aop;

import com.google.inject.ImplementedBy;

/**
 * @author David Kong
 * @version 1.0
 */
@ImplementedBy(ServiceImpl.class)
public interface Service {
    void sayHello();
}
