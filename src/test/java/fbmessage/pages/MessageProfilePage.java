package fbmessage.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageProfilePage extends PageObject {
    @FindBy(xpath = "//div[@aria-label='Message' and @role='button']")
    private WebElementFacade messageButton;

    @FindBy(xpath = "//div[@aria-label='Message' and @role='textbox']")
    private WebElementFacade messageInput;

    @FindBy(xpath = "//div[@aria-label='Press enter to send']")
    private WebElementFacade sendMessageButton;

    public void clickMessageButton() {
        messageButton.click();
    }

    public void sendMessage(WebDriverWait wait, String message) {
        wait.until(ExpectedConditions.elementToBeClickable(messageInput));
        messageInput.type(message);
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
        sendMessageButton.click();
    }
}
