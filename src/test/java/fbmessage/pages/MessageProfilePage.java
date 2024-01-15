package fbmessage.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class MessageProfilePage extends PageObject {
    @FindBy(xpath = "//div[@aria-label='Message' and @role='button']")
    private WebElementFacade messageButton;

    @FindBy(xpath = "//div[@aria-label='Message' and @role='textbox']")
    private WebElementFacade messageInput;

    @FindBy(xpath = "//div[@aria-label='Press enter to send']")
    private WebElementFacade sendMessageButton;

    public void clickMessageButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(messageButton));
        messageButton.click();
        log.info("Clicked on message button");
    }

    public void sendMessage(WebDriverWait wait, String message) {
        wait.until(ExpectedConditions.elementToBeClickable(messageInput));
        messageInput.type(message);
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
        sendMessageButton.click();
        log.info("Message sent");
    }
}
