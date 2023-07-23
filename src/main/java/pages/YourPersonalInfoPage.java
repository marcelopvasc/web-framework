package pages;

import config.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertTrue;


public class YourPersonalInfoPage extends AbstractPage {

    @FindBy(id = "id_gender1")
    private WebElement titleRadio;
    @FindBy(id = "customer_firstname")
    private WebElement nameInput;
    //Using relative xpath
    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement lastNameInput;
    //Using name
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(id = "passwd")
    private WebElement pwdInput;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement daysSelect;
    @FindBy(id = "months")
    private WebElement mothSelect;

    @FindBy(id = "years")
    private WebElement yearSelect;

    @FindBy(id = "newsletter")
    private WebElement signUpNewsCheck;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement alertSuccessMessage;


    @Step("When the user filled all required personal info")
    public void fillingPersonalInfo() {
        waitUntilElementVisible(titleRadio);
        click(titleRadio);
        inputText(nameInput, "John");
        inputText(lastNameInput, "Doe");
        inputText(pwdInput, "12345");
        selectItemDropDown("20",daysSelect);
        selectItemDropDown("6",mothSelect);
        selectItemDropDown("1993",yearSelect);
        click(signUpNewsCheck);
        click(registerButton);

    }

    @Step("Then alert success message should be displayed")
    public void showAlertSuccessMessage(){
        waitUntilElementVisible(alertSuccessMessage);
        assertTrue(alertSuccessMessage.isDisplayed());
    }

    public YourPersonalInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
