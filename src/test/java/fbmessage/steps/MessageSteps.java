package fbmessage.steps;

import fbmessage.pages.MessageLoginPage;
import fbmessage.pages.MessageProfilePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageSteps {

    MessageLoginPage loginPage;
    MessageProfilePage profilePage;

    @Step("Navigate to {0}")
    public void navigateTo(String url) {
        loginPage.openAt(url);
    }

    @Step("Accept cookies")
    public void acceptCookies(WebDriverWait wait) {
        loginPage.acceptCookies(wait);
    }

    @Step("Log in with email {0} and password")
    public void loginWithCredentials(WebDriverWait wait, String email, String password) {
        loginPage.loginWithCredentials(wait, email, password);
    }

    @Step("Click message button on profile")
    public void clickMessageButton(WebDriverWait wait) {
        profilePage.clickMessageButton(wait);
    }

    @Step("Send message")
    public void sendMessage(WebDriverWait wait, String message) {
        profilePage.sendMessage(wait, message);
    }
}
