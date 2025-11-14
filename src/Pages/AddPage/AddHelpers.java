package Pages.AddPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Pages.BasePage.BasePage;

public class AddHelpers extends BasePage {
    public AddHelpers(WebDriver driver) {
        super(driver);
    }

    public void fillEmailForm(String email) {
        findElement(AddLocators.EMAIL_INPUT).sendKeys(email);
    }

    public void fillNameForm(String name) {
        findElement(AddLocators.NAME_INPUT).sendKeys(name);
    }

    public void fillGenderForm(String gender) {
        WebElement genderInput = findElement(AddLocators.GENDER_INPUT);
        Select select = new Select(genderInput);
        select.selectByVisibleText(gender);
    }

    public void chooseCheckBox(int checkBoxNumber) {
        switch (checkBoxNumber) {
            case 1:
                findElement(AddLocators.CHECKBOX1_INPUT).click();
                break;
            case 2:
                findElement(AddLocators.CHECKBOX2_INPUT).click();
                break;
        }
    }

    public void chooseRadioGroup(int radioGroupNumber) {
        switch (radioGroupNumber) {
            case 1:
                findElement(AddLocators.RADIOGROUP1_INPUT).click();
                break;
            case 2:
                findElement(AddLocators.RADIOGROUP2_INPUT).click();
                break;
            case 3:
                findElement(AddLocators.RADIOGROUP3_INPUT).click();
                break;
        }
    }

    public void clickAddButton() {
        findElement(AddLocators.ADD_BUTTON).click();
    }

    public String getErrorNameMessage() {
        return findElement(AddLocators.ERROR_NAME_MESSAGE).getText();
    }

    public String getErrorEmailMessage() {
        return findElement(AddLocators.ERROR_EMAIL_MESSAGE).getText();
    }

    public String getAddSuccessMessage() {
        return findElement(AddLocators.ADD_SUCCESS_MESSAGE).getAttribute("textContent");
    }

    public void clickOkButton() {
        findElement(AddLocators.OK_BUTTON).click();
    }

    public String getEmailTableRow() {
        return findElement(AddLocators.EMAIL_TABLE_ROW).getText();
    }
}
