package k0n9.common.plugins.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author David Kong
 * @version 1.0
 */
public class ApplicationConfiguration extends AbstractModule {

    private static final Logger log = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Override
    protected void configure() {
        Properties properties = new Properties();
        try {
            String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            path = path + "app.properties";
            log.info("Reading Application properties in {}", path);
            properties.load(new FileReader(path));
            Names.bindProperties(binder(), properties);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The configuration file app.properties can not be found");
        } catch (IOException e) {
            throw new RuntimeException("I/O Exception during loading configuration");
        }
    }
}
