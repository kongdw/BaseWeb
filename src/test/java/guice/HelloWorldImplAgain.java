package guice;

/**
 * @author David Kong
 * @version 1.0
 */
public class HelloWorldImplAgain implements HelloWorld {

    @Override
    public String sayHello() {
        return "@HelloWorldImplAgain";
    }
}
