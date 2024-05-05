package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public static Properties getProperties() {
        Properties props = new Properties();
        InputStream propsStream = null;

        try {
            propsStream = Utils.class.getClassLoader().getResourceAsStream("dictcc.properties");
            if (propsStream != null) {
                props.load(propsStream);
            } else {
                throw new FileNotFoundException("Property file 'dictcc.properties' not found in the classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from 'dictcc.properties'", e);
        } finally {
            if (propsStream != null) {
                try {
                    propsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return props;
    }
}