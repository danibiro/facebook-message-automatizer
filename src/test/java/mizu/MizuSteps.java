package mizu;

import net.thucydides.core.annotations.Step;

public class MizuSteps {

    MizuLoginPage page;

    @Step("Navigate to {0}")
    public void navigateTo(String url) {
        page.openAt(url);
    }

    @Step("Accept cookies")
    public void acceptCookies() {
        page.acceptCookies();
    }

    @Step("Log in with email {0} and password")
    public void loginWithCredentials(String email, String password) {
        page.loginWithCredentials(email, password);
    }
}
