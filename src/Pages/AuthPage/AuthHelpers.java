package Pages.AuthPage;

import Pages.AddPage.AddLocators;
import Pages.BasePage.BasePage;
import org.openqa.selenium.WebDriver;

public class AuthHelpers extends BasePage {
    public AuthHelpers(WebDriver driver) {
        super(driver);
    }

    public void fillLoginForm(String login) {
        findElement(AuthLocators.LOGIN_INPUT).sendKeys(login);
    }

    public void fillPasswordForm(String password) {
        findElement(AuthLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickAuthButton() {
        findElement(AuthLocators.AUTH_BUTTON).click();
    }

    public String getErrorMessage() {
        return findElement(AuthLocators.ERROR_MESSAGE).getText();
    }

    public String getInvalidEmailMessage() {
        return findElement(AuthLocators.INVALID_EMAIL).getText();
    }

    public String getSendDataButtonText() {
        return findElement(AddLocators.ADD_BUTTON).getText();
    }
}
