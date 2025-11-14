package Pages.AddPage;

import org.openqa.selenium.By;

public class AddLocators {
    public static final By EMAIL_INPUT = By.xpath("//input[@id='dataEmail']");
    public static final By NAME_INPUT = By.xpath("//input[@id='dataName']");
    public static final By GENDER_INPUT = By.xpath("//select[@id='dataGender']");
    public static final By CHECKBOX1_INPUT = By.xpath("//input[@id='dataCheck11']");
    public static final By CHECKBOX2_INPUT = By.xpath("//input[@id='dataCheck12']");
    public static final By RADIOGROUP1_INPUT = By.xpath("//input[@id='dataSelect21']");
    public static final By RADIOGROUP2_INPUT = By.xpath("//input[@id='dataSelect22']");
    public static final By RADIOGROUP3_INPUT = By.xpath("//input[@id='dataSelect23']");
    public static final By ADD_BUTTON = By.xpath("//button[@id='dataSend']");
    public static final By ERROR_NAME_MESSAGE = By.xpath("//div[@id='blankNameError']");
    public static final By ERROR_EMAIL_MESSAGE = By.xpath("//div[@id='emailFormatError']");
    public static final By ADD_SUCCESS_MESSAGE = By.xpath("//div[@class='uk-margin uk-modal-content']");
    public static final By OK_BUTTON = By.xpath("//button[text()='Ok']");
    public static final By EMAIL_TABLE_ROW = By.xpath("//table[@id='dataTable']/tbody/tr[1]/td[1]");
}
