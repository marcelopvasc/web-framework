package signin;

import config.TestBase;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import pages.SignInPage;
import pages.YourPersonalInfoPage;

public class SignUpTest extends TestBase {

    private SignInPage sg;
    private YourPersonalInfoPage ypi;
    @BeforeClass
    public void setUp() {
        startDriver();
        sg = new SignInPage(driver);
        ypi = new YourPersonalInfoPage(driver);

    }

    @Test(priority=2, description = "Validate Sign Up successful")
    @Severity(SeverityLevel.BLOCKER)
    public void testSignUpSuccessful() {
        sg.firstSignUpForm();
        ypi.fillingPersonalInfo();
        ypi.showAlertSuccessMessage();

    }

    @Test(priority=1, description = "Validate Sign Up with invalid emails")
    @Severity(SeverityLevel.CRITICAL)
    public void testSignUpInvalidEmails() {
        sg.firstSignUpFormWithInvalidEmail();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
