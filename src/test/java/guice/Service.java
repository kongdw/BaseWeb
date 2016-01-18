package guice;

import com.google.inject.ProvidedBy;

/**
 * @author David Kong
 * @version 1.0
 */
@ProvidedBy(WwwServiceProvider.class)
public interface Service {
    void execute();
}
