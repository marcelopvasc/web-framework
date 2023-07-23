package signin;

import config.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import pages.MyAccountPage;
import pages.SignInPage;

public class SignInTest extends TestBase {

    private SignInPage sg;
    private MyAccountPage ma;
    @BeforeClass
    public void setUp() {
        startDriver();
        sg = new SignInPage(driver);
        ma = new MyAccountPage(driver);

    }
    @Test(priority=2, description = "Validate Sign In successful")
    @Severity(SeverityLevel.BLOCKER)
    @Story("As a user I should be able to login to the application")
    public void testSignInSuccessfully() {
        sg.signInForm();
        ma.checkUserLogged();
    }

    @Test(priority=1, description = "Validate Invalid Credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("As a user I should not be able to login to the application with invalid credentials")
    public void testInvalidSignInCredentials() {
        sg.signInFormWithInvalidEmail();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
