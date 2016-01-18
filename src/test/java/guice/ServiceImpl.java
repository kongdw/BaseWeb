package guice;

/**
 * @author David Kong
 * @version 1.0
 */
public class ServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("@ServiceImpl");
    }
}
