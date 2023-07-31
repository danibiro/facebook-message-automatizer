package mizu;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class MizuSteps {

    MizuLoginPage loginPage;
    MsgProfilePage profilePage;

    @Step("Navigate to {0}")
    public void navigateTo(String url) {
        loginPage.openAt(url);
    }

    @Step("Accept cookies")
    public void acceptCookies() {
        loginPage.acceptCookies();
    }

    @Step("Log in with email {0} and password")
    public void loginWithCredentials(String email, String password) {
        loginPage.loginWithCredentials(email, password);
    }

    @Step("Click message button on profile")
    public void clickMessageButton(WebDriver driver) {
        profilePage.clickMessageButton(driver);
    }
}
