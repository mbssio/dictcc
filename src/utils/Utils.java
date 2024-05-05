import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    public static Properties getProperties() {
        Properties props = new Properties();
        InputStream propsPath = null;

        try {
            propsPath = new FileInputStream("src/app.properties");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return props;
    }
}
