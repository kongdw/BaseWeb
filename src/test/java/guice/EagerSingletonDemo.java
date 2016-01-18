package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 立即初始化
 * guice 默认初始化是在对象第一次被调用时初始化，即延时加载，
 * guice也允许对象在注入到guice容器时就被创建出来通过调用
 *        binder.bind(EagerSingletonDemo.class).asEagerSingleton();
 * @author David Kong
 * @version 1.0
 */
public class EagerSingletonDemo {

    public EagerSingletonDemo() {
        System.out.println(" constructor:" + System.nanoTime());
    }

    void doit() {
        System.out.println(" doit:" + System.nanoTime());
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(EagerSingletonDemo.class).asEagerSingleton();
            }
        });
        System.out.println(" before call:"+ System.nanoTime());
        injector.getInstance(EagerSingletonDemo.class).doit();
    }
}
