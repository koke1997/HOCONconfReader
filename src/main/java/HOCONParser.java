import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueType;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class HOCONParser {

    public static Set<String> parseConfig(String filePath) {
        Config config = ConfigFactory.parseFile(new File(filePath));
        return getAllKeys(config);
    }

    private static Set<String> getAllKeys(Config config) {
        return getAllKeys(config, "");
    }

    private static Set<String> getAllKeys(Config config, String parentKey) {
        Set<String> keys = new HashSet<>();
        for (String key : config.root().keySet()) {
            String fullKey = parentKey.isEmpty() ? key : parentKey + "." + key;
            if (config.getValue(key).valueType() == ConfigValueType.OBJECT) {
                keys.addAll(getAllKeys(config.getConfig(key), fullKey));
            } else {
                keys.add(fullKey);
            }
        }
        return keys;
    }
}
