package guice;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * 构造函数注入
 * @author David Kong
 * @version 1.0
 */
public class ConstructorInjectDemo {

    private Service service;

    @Inject
    public ConstructorInjectDemo(Service service){
        this.service = service;
    }

    public Service getService(){
        return service;
    }

    public static void main(String[] args) {
        ConstructorInjectDemo demo = Guice.createInjector().getInstance(ConstructorInjectDemo.class);
        demo.getService().execute();
    }
}
