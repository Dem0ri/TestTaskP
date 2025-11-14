package Tests;

import Pages.AuthPage.AuthHelpers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuth extends BaseTest {

    private AuthHelpers authPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        authPage = new AuthHelpers(driver);
    }

    @Test
    public void testValidLoginAndPassword() {
        authPage.fillLoginForm("test@protei.ru");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
        String buttonAuth = authPage.getSendDataButtonText();
        assertEquals("Добавить", buttonAuth);
    }

    @Test
    public void testZeroDataAndPassword() {
        authPage.fillLoginForm("");
        authPage.fillPasswordForm("");
        authPage.clickAuthButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals("Неверный формат E-Mail", errorMessage);
    }

    @Test
    public void testZeroPasswordValidEmail() {
        authPage.fillLoginForm("test@protei.ru");
        authPage.fillPasswordForm("");
        authPage.clickAuthButton();
        String invalidEmail = authPage.getInvalidEmailMessage();
        assertEquals("Неверный E-Mail или пароль", invalidEmail);
    }

    @Test
    public void testZeroDataValidPassword() {
        authPage.fillLoginForm("");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals("Неверный формат E-Mail", errorMessage);
    }

    @Test
    public void testValidDataInvalidPassword() {
        authPage.fillLoginForm("test@protei.ru");
        authPage.fillPasswordForm("zxcv");
        authPage.clickAuthButton();
        String invalidEmail = authPage.getInvalidEmailMessage();
        assertEquals("Неверный E-Mail или пароль", invalidEmail);
    }

    @Test
    public void testInvalidDataValidPassword() {
        authPage.fillLoginForm("boods@pratei.ge");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
        String invalidEmail = authPage.getInvalidEmailMessage();
        assertEquals("Неверный E-Mail или пароль", invalidEmail);
    }

    @Test
    public void testKirilizaDataValidPassword() {
        authPage.fillLoginForm("тест@протей.ру");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
        String invalidEmail = authPage.getInvalidEmailMessage();
        assertEquals("Неверный E-Mail или пароль", invalidEmail);
    }

    @Test
    public void testInvalidFormatDataValidPassword() {
        authPage.fillLoginForm("testprotei.ru");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals("Неверный формат E-Mail", errorMessage);
    }

    @Test
    public void testMinVormatDataValidPassword() {
        authPage.fillLoginForm("@protei.ru");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals("Неверный формат E-Mail", errorMessage);
    }

    @Test
    public void testSpezSimDataValidPassword() {
        authPage.fillLoginForm("!test@protei.ru");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
        String invalidEmail = authPage.getInvalidEmailMessage();
        assertEquals("Неверный E-Mail или пароль", invalidEmail);
    }

    @Test
    public void testValidDataProbelPassword() {
        authPage.fillLoginForm("!test@protei.ru");
        authPage.fillPasswordForm("test ");
        authPage.clickAuthButton();
        String invalidEmail = authPage.getInvalidEmailMessage();
        assertEquals("Неверный E-Mail или пароль", invalidEmail);
    }
}