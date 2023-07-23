package pages;

import java.time.Duration;

import config.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

//This class is usefull to prevent duplicate code and add Reusability to the framework
public class AbstractPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Faker faker = new Faker();

    public void waitUntilElementVisible(WebElement wb) {

        wait.until(ExpectedConditions.visibilityOf(wb));
    }

    public String fakerEmail(){
        return faker.internet().emailAddress();
    }

    public void clear(WebElement wb){
        wb.clear();
    }

    public void waitUntilElementClickable(WebElement wb) {
        wait.until(ExpectedConditions.elementToBeClickable(wb));
    }

    public void click(WebElement wb) {
        wb.click();
    }

    public String getTextFromElement(WebElement wb) {
        waitUntilElementVisible(wb);
        String txtElement = wb.getText();
        return txtElement;
    }

    public void inputText(WebElement wb, String text) {
        clear(wb);
        waitUntilElementVisible(wb);
        wb.sendKeys(text);
    }
    
    public void selectItemDropDown(String value, WebElement selectType){
        Select select = new Select(selectType);
        select.selectByValue(value);
    }


}
