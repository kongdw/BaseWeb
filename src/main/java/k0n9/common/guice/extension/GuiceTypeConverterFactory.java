package k0n9.common.guice.extension;

import com.google.inject.Injector;
import k0n9.common.guice.utils.Helpers;
import net.sourceforge.stripes.validation.DefaultTypeConverterFactory;
import net.sourceforge.stripes.validation.TypeConverter;

import java.util.Locale;

/**
 * @author David Kong
 * @version 1.0
 */
public class GuiceTypeConverterFactory extends DefaultTypeConverterFactory {

    @Override
    public TypeConverter getInstance(Class<? extends TypeConverter> clazz, Locale locale) throws Exception {
        Injector injector = Helpers.getInjector(getConfiguration().getServletContext());
        TypeConverter typeConverter = injector.getInstance(clazz);
        typeConverter.setLocale(locale);
        return typeConverter;
    }
}
