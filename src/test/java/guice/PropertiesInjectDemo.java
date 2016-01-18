package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author David Kong
 * @version 1.0
 */
public class PropertiesInjectDemo {

    @Inject
    @Named("web")
    private String web;

    public static void main(String[] args) {
        PropertiesInjectDemo demo = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                Properties properties = new Properties();
                try {
                    String path = PropertiesInjectDemo.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "test.properties";
                    System.out.println(path);
                    properties.load(new FileReader(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Names.bindProperties(binder, properties);
            }
        }).getInstance(PropertiesInjectDemo.class);
        System.out.println(demo.web);
    }

}
