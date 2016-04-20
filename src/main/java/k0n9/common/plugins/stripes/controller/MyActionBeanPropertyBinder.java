package k0n9.common.plugins.stripes.controller;

import com.google.common.collect.Maps;
import k0n9.common.entity.search.Searchable;
import k0n9.common.web.resolver.SearchableArgumentResolver;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.controller.DefaultActionBeanPropertyBinder;
import net.sourceforge.stripes.controller.ParameterName;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.ScopedLocalizableError;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMetadata;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;


/**
 * @author David Kong
 * @version 1.0
 */
public class MyActionBeanPropertyBinder extends DefaultActionBeanPropertyBinder {

    private static final Log log = Log.getInstance(MyActionBeanPropertyBinder.class);

    private static final String SEARCHABLE_PROPERTY_KEY = "searchable";

    private static final Pattern SEARCHABLE_PROPERTY_PATTERN = Pattern.compile("(search|sort|page)[._]");

    private void bindSearchable(ActionBean bean, ActionBeanContext context) {
        ValidationErrors errors = context.getValidationErrors();
        Class superClazz = bean.getClass().getSuperclass();
        Class clazz = bean.getClass();
        Field searchableField = null;
        try {
            searchableField = clazz.getDeclaredField(SEARCHABLE_PROPERTY_KEY);
        } catch (NoSuchFieldException e) {
            log.debug("本类中未找到searchable属性,查询super class.");
            try {
                searchableField = superClazz.getDeclaredField(SEARCHABLE_PROPERTY_KEY);
            } catch (NoSuchFieldException e1) {
                log.debug("super class中未找到searchable属性.");
                return;
            }
        }
        if (searchableField != null && searchableField.getType().isAssignableFrom(Searchable.class)) {
            Searchable searchable = (Searchable) new SearchableArgumentResolver().resolveArgument(bean, context);
            try {
                searchableField.setAccessible(true);
                searchableField.set(bean, searchable);
            } catch (IllegalAccessException e) {
                ValidationError error = new ScopedLocalizableError("validation.required",
                        "valueNotPresent");
                error.setFieldValue(searchable.toString());
                errors.add(SEARCHABLE_PROPERTY_KEY, error);
            }
        }
    }

    @Override
    public ValidationErrors bind(ActionBean bean, ActionBeanContext context, boolean validate) {
        bindSearchable(bean, context);
        return super.bind(bean, context, validate);
    }

    @Override
    protected SortedMap<ParameterName, String[]> getParameters(ActionBean bean) {
        Map<String, String[]> requestParameters = getNotPrefixParameterMap(SEARCHABLE_PROPERTY_PATTERN, bean.getContext().getRequest());
        Map<String, ValidationMetadata> validations = StripesFilter.getConfiguration()
                .getValidationMetadataProvider().getValidationMetadata(bean.getClass());
        SortedMap<ParameterName, String[]> parameters = new TreeMap<ParameterName, String[]>();

        for (Map.Entry<String, String[]> entry : requestParameters.entrySet()) {
            ParameterName paramName = new ParameterName(entry.getKey().trim());
            ValidationMetadata validation = validations.get(paramName.getStrippedName());
            parameters.put(paramName, trim(entry.getValue(), validation));
        }

        return parameters;
    }

    protected Map<String, String[]> getNotPrefixParameterMap(Pattern pattern, HttpServletRequest request) {
        Map<String, String[]> result = Maps.newHashMap();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if (!pattern.matcher(name).find()) {
                result.put(name, request.getParameterValues(name));
            }
        }
        return result;
    }
}
