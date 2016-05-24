import k0n9.common.entity.search.SearchOperator;
import net.sourceforge.stripes.util.Base64;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.mybatis.guice.transactional.Transactional;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author David Kong
 * @version 1.0
 */
public class MethodTest {

    @Transactional
    public void test(int a, Date b) {

    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchAlgorithmException {
        SearchOperator searchOperator = SearchOperator.suffixLike;
        System.out.println(searchOperator.toString());
        System.out.println(SearchOperator.suffixLike.toString());
        System.out.println(SearchOperator.suffixLike.getSymbol());
        String password = "123456";
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] bytes = md.digest(password.getBytes());
        password =  Base64.encodeBytes(bytes);
        System.out.println(password);
        Method[] methods = MethodUtils.getMethodsWithAnnotation(MethodTest.class, Transactional.class);
        for (Method method : methods) {
            System.out.println(String.format("Method Name is %s",method.getName()));
            for(Annotation annotation: method.getDeclaredAnnotations()) {
               if(Transactional.class.isInstance(annotation)){
                    Transactional transactional = (Transactional) annotation;
                   System.out.println(transactional.executorType());
                   System.out.println(transactional.exceptionMessage());
                   System.out.println(transactional.isolation());
               }
            }
        }
    }
}
