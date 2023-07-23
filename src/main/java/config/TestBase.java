package config;

import io.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static util.ConfigFileReader.getProperty;

public class TestBase {
    public static WebDriver driver;

    public static void startDriver() {

        if (getProperty("browser").equals("chrome") || getProperty("browser").equals("")) {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.silentOutput", "true");
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            System.out.println("Browser is set to chrome");

            //Example with headless mode
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("headless");
            driver = new ChromeDriver(options);

        }else if(getProperty("browser").equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            System.out.println("Browser is set to firefox");
            driver = new FirefoxDriver();
        }else{
            WebDriverManager.edgedriver().setup();
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            System.out.println("Browser is set to Edge");
            driver = new EdgeDriver();
        }
        try {
            driver.manage().window().maximize();
            driver.get(getProperty("application_url"));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}