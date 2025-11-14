package Pages.AuthPage;

import org.openqa.selenium.By;

public class AuthLocators {
    public static final By LOGIN_INPUT = By.xpath("//input[@id='loginEmail']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='loginPassword']");
    public static final By AUTH_BUTTON = By.xpath("//button[@id='authButton']");
    public static final By ERROR_MESSAGE = By.xpath("//div[@id='emailFormatError']");
    public static final By INVALID_EMAIL = By.xpath("//div[@id='invalidEmailPassword']");
}
