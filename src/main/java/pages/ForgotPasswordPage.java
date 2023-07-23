package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertTrue;
import static util.ConfigFileReader.getProperty;

public class ForgotPasswordPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement emailInputRetrieve;

    @FindBy(xpath = "//p[@class='submit']/button")
    private WebElement submitButtonRetrieve;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement alertSuccessMessage;



    @Step("When the user input his password")
    public void inputValidEmailToRetrievePwd(){
        inputText(emailInputRetrieve,"marcelopvam@gmail.com");
        click(submitButtonRetrieve);

    }

    @Step("Then a confirmation message should be displayed")
    public void checkConfirmationMessage(){
        //In the real world, a confirmation should be made in the database or using apis to assure that the email was sent
        waitUntilElementVisible(alertSuccessMessage);
        assertTrue(getTextFromElement(alertSuccessMessage).contains(getProperty("retrieve_pwd_confirmation")));

    }



    public ForgotPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
