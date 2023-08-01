package fbmessage.tests;

import fbmessage.steps.MessageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Map;

@ExtendWith(SerenityJUnit5Extension.class)
public class MessageTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    MessageSteps steps;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void sendTextTest() {
        String url = "https://facebook.com/";
        Map<String, Object> userConfig = readConfig("user_config.yaml");
        Map<String, Object> messageConfig = readConfig("message_config.yaml");
        assert userConfig != null;
        assert messageConfig != null;
        steps.navigateTo(url + "login");
        steps.acceptCookies();
        steps.loginWithCredentials(userConfig.get("email").toString(), userConfig.get("password").toString());
        steps.navigateTo(url + messageConfig.get("username").toString());
        steps.clickMessageButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        steps.sendMessage(wait, messageConfig.get("message").toString());
    }

    public static Map<String, Object> readConfig(String filename) {
        ClassLoader classLoader = MessageTest.class.getClassLoader();

        Yaml yaml = new Yaml();
        try (InputStream inputStream = classLoader.getResourceAsStream(filename)) {
            return yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
