package signin;

import config.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.MyAccountPage;
import pages.SignInPage;

public class ForgotPasswordTest extends TestBase {

    private SignInPage sg;
    private ForgotPasswordPage fp;
    @BeforeClass
    public void setUp() {
        startDriver();
        sg = new SignInPage(driver);
        fp = new ForgotPasswordPage(driver);

    }
    @Test(priority=1, description = "Retrieve passoword successfully")
    @Severity(SeverityLevel.BLOCKER)
    @Story("As a user I should be able to retrieve my password")
    public void testRetrievePasswordSuccessufully() {
        sg.goToForgotPwdPage();
        fp.inputValidEmailToRetrievePwd();
        fp.checkConfirmationMessage();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
