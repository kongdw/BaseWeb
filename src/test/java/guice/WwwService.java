package guice;

/**
 * @author David Kong
 * @version 1.0
 */
public class WwwService implements Service {
    @Override
    public void execute() {
        System.out.println("@WwwService");
    }
}
