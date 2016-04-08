package k0n9.common.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 系统配置文件读取
 * @author David Kong
 * @version 1.0
 */
public class ApplicationConfiguration extends AbstractModule {

    private static final String APP_CONFIGURE_FILE = "app.properties";

    private static final Logger log = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Override
    protected void configure() {
        Properties prop = new Properties();
        try {
            InputStream in = ApplicationConfiguration.class.getResourceAsStream("/" + APP_CONFIGURE_FILE);
            log.info("Reading Application properties in {}", APP_CONFIGURE_FILE);
            prop.load(in);
            Names.bindProperties(binder(), prop);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The configuration file app.properties can not be found");
        } catch (IOException e) {
            throw new RuntimeException("I/O Exception during loading configuration");
        }
    }
}
