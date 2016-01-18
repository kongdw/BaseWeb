package guice.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author David Kong
 * @version 1.0
 */
public class LoggerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String methodName = methodInvocation.getMethod().getName();
        long startTime = System.nanoTime();
        System.out.println(String.format("before method[%s] at %s", methodName, startTime));
        Object obj = null;
        try {
            obj = methodInvocation.proceed();
        } finally {
            long endTime = System.nanoTime();
            System.out.println(String.format("after method[%s] at %s,cost(ns):%d", methodName, endTime, (endTime - startTime)));
        }
        return obj;
    }
}
