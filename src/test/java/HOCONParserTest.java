import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HOCONParserTest {

    @Test
    public void testParseConfig() {
        String filePath = "src/test/resources/test.conf";
        Set<String> expectedKeys = Set.of(
                "included.settingA",
                "included.settingB",
                "main.setting1",
                "main.setting2"
        );
        Set<String> result = HOCONParser.parseConfig(filePath);
        assertEquals(expectedKeys, result);
    }

    @Test
    public void testParseIncludedConfig() {
        String filePath = "src/test/resources/test.conf";
        Set<String> expectedKeys = Set.of(
                "included.settingA",
                "included.settingB",
                "main.setting1",
                "main.setting2"
        );
        Set<String> result = HOCONParser.parseConfig(filePath);
        assertEquals(expectedKeys, result);
    }
}
