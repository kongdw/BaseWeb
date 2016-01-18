package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author David Kong
 * @version 1.0
 */
public class HelloWorldTest {

    private Injector injector;

    @Before
    public void init() {
        this.injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
            }
        });
    }

    @Test
    public void testSayHello() {
        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        System.out.println(helloWorld.getClass().getName());
        Assert.assertEquals(helloWorld.sayHello(), "Hello World!");
    }

    /**
     * 问题： HelloWorld 是单例的么？
     * 回答：缺省情况下Google guice 每次都会返回新对象。
     * 注意：我们可以在绑定的时候指定构建对象的策略
     * binder.bind(HelloWorld.class).to(HelloWorldImpl.class).in(Singleton.class);
     */
    @Test
    public void testDefaultNotSingleton() {
        HelloWorld h1 = injector.getInstance(HelloWorld.class);
        HelloWorld h2 = injector.getInstance(HelloWorld.class);
        System.out.println(h1.hashCode() + "->" + h2.hashCode());
        Assert.assertNotEquals(h1.hashCode(), h2.hashCode());
    }

    /**
     * 问题：HelloWorld的实例是HelloWorldImpl么？可以强制转型么？
     * 回答：结果输出guice.HelloWorldImpl，看来确实只是返回了一个正常的实例，并没有做过多的转换和代理。
     */
    @Test
    public void testGuiceInstanceIsImpl() {
        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        System.out.println(helloWorld.getClass().getName());
    }

    /**
     * 问题：如果绑定多个实现到同一个接口上会出现什么情况？
     * 回答：很不幸，Guice目前看起来不允许多个实例绑定到同一个接口上了。
     * com.google.inject.CreationException: Unable to create injector, see the following errors:
     * 1) A binding to guice.HelloWorld was already configured at guice.HelloWorldTest$2.configure(HelloWorldTest.java:68).
     * at guice.HelloWorldTest$2.configure(HelloWorldTest.java:69)
     */
    @Test
    public void testBinderMoreImpl() {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
                binder.bind(HelloWorld.class).to(HelloWorldImplAgain.class);
            }
        });
        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        Assert.assertEquals(helloWorld.sayHello(), "@HelloWorldImplAgain");
    }

    /**
     * 问题：可以绑定一个实现类到实现类么？
     * 回答：非常不幸，不可以自己绑定到自己。
     * com.google.inject.CreationException: Unable to create injector, see the following errors:
     * 1) Binding points to itself.
     * at guice.HelloWorldTest$3.configure(HelloWorldTest.java:87)
     * 我们来看看bind的语法。
     * <T> AnnotatedBindingBuilder<T> bind(Class<T> type);
     * ScopedBindingBuilder to(Class<? extends T> implementation);
     * 可以绑定一个子类到本身
     */
    @Test
    public void testBinderSelf() {
        Injector inj = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorldImpl.class).to(HelloWorldImpl.class);
            }
        });
        HelloWorldImpl impl = inj.getInstance(HelloWorldImpl.class);
        Assert.assertEquals(impl.sayHello(), "Hello World!");
    }

    /**
     * 可以绑定子类到本身
     */
    @Test
    public void testBinderSubClass() {
        Injector inj = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorldImpl.class).to(HelloWorldSubImpl.class);
            }
        });
        Assert.assertEquals(inj.getInstance(HelloWorldImpl.class).sayHello(), "@HelloWorldSubImpl");
    }

    /**
     * 问题（5），可以绑定到我们自己构造出来的实例么？
     * <p>
     * 解答（5）当然可以！看下面的例子。
     */
    @Test
    public void testCusTomImpl() {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).toInstance(new HelloWorldImpl());
            }
        });
        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        Assert.assertEquals(helloWorld.sayHello(), "Hello World!");
    }

    /**
     * 问题：我不想自己提供逻辑来构造一个对象可以么？
     * 解答：可以Guice提供了一个方式（Provider<T>），允许自己提供构造对象的方式。
     */
    @Test
    public void testProvider() {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).toProvider(new Provider<HelloWorld>() {
                    @Override
                    public HelloWorld get() {
                        return new HelloWorldImpl();
                    }
                });
            }
        });

        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        Assert.assertEquals(helloWorld.sayHello(), "Hello World!");
    }
}
