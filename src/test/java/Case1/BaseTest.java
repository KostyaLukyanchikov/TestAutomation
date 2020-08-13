package Case1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;


public abstract class BaseTest {

    protected WebDriver driver;
    String epamUrl = PropertyReader.getInstance().getUrl();

    @BeforeSuite
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.get(epamUrl);
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
