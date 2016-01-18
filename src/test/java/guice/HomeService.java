package guice;

/**
 * @author David Kong
 * @version 1.0
 */
public class HomeService implements Service {
    @Override
    public void execute() {
        System.out.println("@HomeService");
    }
}
