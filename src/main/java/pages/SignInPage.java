package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;
import static util.ConfigFileReader.getProperty;

public class SignInPage extends AbstractPage {

    @FindBy(id = "email_create")
    private WebElement emailInputSigUp;

    @FindBy(id = "SubmitCreate")
    private WebElement submitButtonSigUp;

    @FindBy(xpath = "//div[@id='create_account_error']/ol/li")
    private WebElement errorMessageAccountCreation;

    @FindBy(id = "email")
    private WebElement emailInputSignIn;

    @FindBy(id = "passwd")
    private WebElement pwdInputSignIn;

    @FindBy(id = "SubmitLogin")
    private WebElement submitSignInButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    private WebElement authMessageError;

    @FindBy(xpath = "//p[@class='lost_password form-group']/a")
    private WebElement forgotPwdLink;

    @Step("Given a user forgot the password, And click on forgot password link")
    public void goToForgotPwdPage(){
        click(forgotPwdLink);
    }

    @Step("Given a user input an valid email to sigup")
    public void firstSignUpForm(){
        inputText(emailInputSigUp,fakerEmail());
        click(submitButtonSigUp);

    }

    @Step("Given a user input an invalid email to signup, Then alert error message should be displayed")
    public void firstSignUpFormWithInvalidEmail(){

        //This is not the better way to do it, in a real world it`s better use resource files like json, excel, etc, to let this resources available for other parts of the automation
        List<String> invalidEmails = new ArrayList();
        invalidEmails.add("test@");
        invalidEmails.add("test@com");
        invalidEmails.add("@com.br");
        invalidEmails.add("test@test.com");
        invalidEmails.add("");

        for(String email: invalidEmails){
            inputText(emailInputSigUp,email);
            click(submitButtonSigUp);
            waitUntilElementVisible(errorMessageAccountCreation);
            assertTrue(getTextFromElement(errorMessageAccountCreation).contains("email address"));
        }
    }

    @Step("Given a user input an invalid email to sign, Then alert auth error message should be displayed")
    public void signInFormWithInvalidEmail(){

        //This is not the better way to do it, in a real world it`s better use resource files like json, excel, etc, to let this resources available for other parts of the automation
        Map<String, String> invalidCredentials = new HashMap<String, String>();
        invalidCredentials.put("test@", "12345");
        invalidCredentials.put("marcelopvam@gmail.com", "00000000000000000");
        invalidCredentials.put("@com.br","12345");
        invalidCredentials.put("","");
        invalidCredentials.put("test@test.com","");

        for(Map.Entry<String,String> credentials: invalidCredentials.entrySet()){
            inputText(emailInputSignIn,credentials.getKey());
            inputText(pwdInputSignIn,credentials.getValue());
            click(submitSignInButton);
            waitUntilElementVisible(authMessageError);
            assertTrue(getTextFromElement(authMessageError).contains("There is 1 error"));
        }
    }

    @Step("Given a user input an valid email to sigup")
    public void signInForm(){
        inputText(emailInputSignIn,getProperty("user_registered"));
        inputText(pwdInputSignIn,getProperty("user_registered_pwd"));
        click(submitSignInButton);

    }


    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
