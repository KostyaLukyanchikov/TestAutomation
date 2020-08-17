package selenuim.cases;

import entities.User;
import enums.LoginUser;
import enums.UIElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ReporterConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;

import java.util.Properties;

import static org.testng.Assert.assertEquals;


public abstract class BaseTest {

    protected WebDriver driver;
    Properties propValues = PropertyReader.getInstance();
    String epamUrl = propValues.getProperty("url");

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

    protected void login(LoginUser loginUser) {

        User user = new User(loginUser);

        homePageAssertion();


        driver.findElement(By.xpath("//div[contains(@class, 'profile')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'name')]")).sendKeys(user.getUserName());
        driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();

        userNameAssersion(user);
    }

    //Common Assertions
    public void homePageAssertion() {
        assertEquals(driver.getTitle(), UIElements.HOME_PAGE.getUiElement());
    }

    public void userNameAssersion(User user) {
        assertEquals(driver.findElement(By.id("user-name")).getText(), user.getUserCredentials());
    }

}
