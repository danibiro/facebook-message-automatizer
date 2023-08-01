package fbmessage.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MessageLoginPage extends PageObject {

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _al66 _4jy3 _4jy1 selected _51sy']")
    private WebElementFacade acceptCookiesButton;

    @FindBy(xpath = "//input[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//input[@class='inputtext _55r1 inputtext _9npi inputtext _9npi']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _52e0 _4jy6 _4jy1 selected _51sy']")
    private WebElementFacade loginButton;

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public void loginWithCredentials(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
        loginButton.click();
    }
}
