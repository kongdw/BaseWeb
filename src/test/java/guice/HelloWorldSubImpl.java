package guice;

/**
 * @author David Kong
 * @version 1.0
 */
public class HelloWorldSubImpl extends HelloWorldImpl {
    @Override
    public String sayHello() {
        return "@HelloWorldSubImpl";
    }
}
