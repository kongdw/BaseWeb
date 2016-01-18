package guice;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * guice 属性注入方式
 * @author David Kong
 * @version 1.0
 */
public class FieldInjectDemo {

    @Inject
    private Service service;

    public Service getService(){
        return service;
    }

    public static void main(String[] args) {
        FieldInjectDemo demo = Guice.createInjector().getInstance(FieldInjectDemo.class);
        demo.getService().execute();
    }
}
