package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.Date;

/**
 * @author David Kong
 * @version 1.0
 */
public class ConstantInjectDemo {

    @Inject
    @Named("aInt")
    private int aInt;
    @Inject
    @Named("aStr")
    private String aStr;
    @Inject
    @Named("aDate")
    private long aDate;

    public static void main(String[] args) {
       ConstantInjectDemo constant =  Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bindConstant().annotatedWith(Names.named("aInt")).to(12);
                binder.bindConstant().annotatedWith(Names.named("aStr")).to("Hello Guice!");
                binder.bindConstant().annotatedWith(Names.named("aDate")).to(new Date().getTime());
            }
        }).getInstance(ConstantInjectDemo.class);
        System.out.println(constant.aInt);
        System.out.println(constant.aStr);
        System.out.println(new Date(constant.aDate).toString());
    }
}
