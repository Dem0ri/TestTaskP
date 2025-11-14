package Tests;

import Pages.AddPage.AddHelpers;
import Pages.AuthPage.AuthHelpers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddUser extends BaseTest {

    private AddHelpers addPage;
    private AuthHelpers authPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        addPage = new AddHelpers(driver);
        authPage = new AuthHelpers(driver);
        addPage.goToSite();
        authPage.fillLoginForm("test@protei.ru");
        authPage.fillPasswordForm("test");
        authPage.clickAuthButton();
    }

    @Test
    public void testAddUserWithValidData() {
        addPage.fillEmailForm("abc@mail.ru");
        addPage.fillNameForm("Михаил");
        addPage.fillGenderForm("Мужской");
        addPage.chooseCheckBox(1);
        addPage.chooseRadioGroup(3);
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }

    @Test
    public void testAddUserManWithAllCheckboxes() {
        addPage.fillEmailForm("abc@mail.ru");
        addPage.fillNameForm("Сергей");
        addPage.fillGenderForm("Мужской");
        addPage.chooseCheckBox(1);
        addPage.chooseCheckBox(2);
        addPage.chooseRadioGroup(2);
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }

    @Test
    public void testAddUserWomanWithAllCheckboxes() {
        addPage.fillEmailForm("svet@mailz.ru");
        addPage.fillNameForm("Светлана");
        addPage.fillGenderForm("Женский");
        addPage.chooseCheckBox(1);
        addPage.chooseCheckBox(2);
        addPage.chooseRadioGroup(2);
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }

    @Test
    public void testAddUserZeroNameForm() {
        addPage.fillEmailForm("ssdv@mail.ru");
        addPage.fillNameForm("");
        addPage.fillGenderForm("Женский");
        addPage.chooseCheckBox(2);
        addPage.chooseRadioGroup(1);
        addPage.clickAddButton();
        String errorName = addPage.getErrorNameMessage();
        assertEquals("Поле имя не может быть пустым", errorName);
    }

    @Test
    public void testAddUserZeroEmailForm() {
        addPage.fillEmailForm("");
        addPage.fillNameForm("Никита");
        addPage.fillGenderForm("Мужской");
        addPage.chooseCheckBox(2);
        addPage.chooseRadioGroup(2);
        addPage.clickAddButton();
        String errorEmail = addPage.getErrorEmailMessage();
        assertEquals("Неверный формат E-Mail", errorEmail);
    }

    @Test
    public void testAddUserInvalidEmailForm() {
        addPage.fillEmailForm("@mail.ru");
        addPage.fillNameForm("Екатерина");
        addPage.fillGenderForm("Женский");
        addPage.chooseCheckBox(1);
        addPage.chooseRadioGroup(3);
        addPage.clickAddButton();
        String errorEmail = addPage.getErrorEmailMessage();
        assertEquals("Неверный формат E-Mail", errorEmail);
    }

    @Test
    public void testAddUserWithoutProbelNameForm() {
        addPage.fillEmailForm("czxc@mail.ru");
        addPage.fillNameForm(" Нина ");
        addPage.fillGenderForm("Женский");
        addPage.chooseCheckBox(1);
        addPage.chooseRadioGroup(2);
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }

    @Test
    public void testAddUserZeroChooseCheckbox() {
        addPage.fillEmailForm("jfscb@mail.ru");
        addPage.fillNameForm("Аркадий");
        addPage.fillGenderForm("Мужской");
        addPage.chooseRadioGroup(1);
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }

    @Test
    public void testAddUserProofAddInTable() {
        addPage.fillEmailForm("onebv@mail.ru");
        addPage.fillNameForm("Виктория");
        addPage.fillGenderForm("Женский");
        addPage.chooseCheckBox(2);
        addPage.chooseRadioGroup(1);
        addPage.clickAddButton();
        addPage.clickOkButton();
        String tableEmail = addPage.getEmailTableRow();
        assertEquals("onebv@mail.ru", tableEmail);
    }

    @Test
    public void testAddUserZeroChooseRadioGroup() {
        addPage.fillEmailForm("zxvjn@mail.ru");
        addPage.fillNameForm("Игорь");
        addPage.fillGenderForm("Мужской");
        addPage.chooseCheckBox(2);
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }

    @Test
    public void testAddUserZeroChooseRadioGroupAndCheckbox() {
        addPage.fillEmailForm("nmvbcx@mail.ru");
        addPage.fillNameForm("Татьяна");
        addPage.fillGenderForm("Женский");
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }

    @Test
    public void testAddUserWithMinNameForm() {
        addPage.fillEmailForm("reuuqdc@mail.ru");
        addPage.fillNameForm("М");
        addPage.fillGenderForm("Мужской");
        addPage.chooseCheckBox(1);
        addPage.chooseRadioGroup(2);
        addPage.clickAddButton();
        String addMessage = addPage.getAddSuccessMessage();
        assertEquals("Данные добавлены.", addMessage);
    }
}
