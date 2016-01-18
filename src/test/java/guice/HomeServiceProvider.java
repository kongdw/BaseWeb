package guice;

import com.google.inject.Provider;

/**
 * @author David Kong
 * @version 1.0
 */
public class HomeServiceProvider implements Provider<Service> {
    @Override
    public Service get() {
        return new HomeService();
    }
}
