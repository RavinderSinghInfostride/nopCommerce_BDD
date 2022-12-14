package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    protected PageFactory pageFactory;
    WebDriver driver;

    public void setup() throws IOException {
        FileReader reader = new FileReader("src/test/java/TestData/Data.properties");

        Properties data = new Properties();
        data.load(reader);
        String websiteUrl = data.getProperty("url");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to(websiteUrl);
        pageFactory = new PageFactory(driver);
    }

    public void close_browser()
    {
        driver.close();
    }
}