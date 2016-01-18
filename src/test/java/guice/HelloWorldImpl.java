package guice;

/**
 * @author David Kong
 * @version 1.0
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello() {
        return "Hello World!";
    }

}
