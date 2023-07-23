package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;
import static util.ConfigFileReader.getProperty;

public class MyAccountPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='account']/span[contains(text(),'Marcelo')]")
    private WebElement userNameHeader;

    @Step("Then user should be login successfully")
    public void checkUserLogged(){
        waitUntilElementVisible(userNameHeader);
        assertTrue(getTextFromElement(userNameHeader).contains("Vasconcelos"));

    }



    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
