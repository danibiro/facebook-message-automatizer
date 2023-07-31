package mizu;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@ExtendWith(SerenityJUnit5Extension.class)
public class MizuTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    MizuSteps steps;

    @Test
    public void sendTextTest() {
        String url = "https://facebook.com/messages";
        Map<String, Object> config = readConfig("/user_config.yaml");
        assert config != null;
        steps.navigateTo(url);
        steps.acceptCookies();
        steps.loginWithCredentials(config.get("email").toString(), config.get("password").toString());
    }

    public static Map<String, Object> readConfig(String filename) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream(filename);
            return yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
