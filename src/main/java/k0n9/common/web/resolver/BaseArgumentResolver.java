package k0n9.common.web.resolver;

import com.google.common.collect.Maps;
import net.sourceforge.stripes.controller.ExecutionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * 参数解析器基础类
 *
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseArgumentResolver {
    /**
     * 获取指定前缀的参数：包括uri variables 和 parameters
     *
     * @param namePrefix
     * @param request
     * @return
     * @subPrefix 是否截取掉namePrefix的前缀
     */
    protected Map<String, String[]> getPrefixParameterMap(String namePrefix, HttpServletRequest request, boolean subPrefix) {
        Map<String, String[]> result = Maps.newHashMap();
        int namePrefixLength = namePrefix.length();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if (name.startsWith(namePrefix)) {
                //page.pn  则截取 pn
                if (subPrefix) {
                    char ch = name.charAt(namePrefixLength);
                    //如果下一个字符不是 数字 . _  则不可能是查询 只是前缀类似
                    if (illegalChar(ch)) {
                        continue;
                    }
                    result.put(name.substring(namePrefixLength + 1), request.getParameterValues(name));
                } else {
                    result.put(name, request.getParameterValues(name));
                }
            }
        }
        //Enumeration<String> attributeNames = request.getAttributeNames();
        //while (attributeNames.hasMoreElements()) {
        //    String name = attributeNames.nextElement();
        //    if (name.startsWith(namePrefix)) {
        //        if (subPrefix) {
        //            char ch = name.charAt(namePrefixLength);
        //            if (illegalChar(ch)) {
        //                continue;
        //            }
        //            result.put(name.substring(namePrefixLength + 1), new String[]{(String) request.getAttribute(name)});
        //        } else {
        //            result.put(name, new String[]{(String) request.getAttribute(name)});
        //        }
        //    }
        //}
        return result;
    }

    private boolean illegalChar(char ch) {
        return ch != '.' && ch != '_' && !(ch >= '0' && ch <= '9');
    }

    public abstract Object resolveArgument(ExecutionContext executionContext);


}
