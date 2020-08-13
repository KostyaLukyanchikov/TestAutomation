package сase1;

import entities.User;
import enums.UserPiterChailovskii;
import enums.UIElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;

import static org.testng.Assert.assertEquals;


public abstract class BaseTest {

    protected WebDriver driver;
    String epamUrl = PropertyReader.getInstance().getUrl();
    String epamUserName = PropertyReader.getInstance().getUserName();
    String epamPassword = PropertyReader.getInstance().getPassword();

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

    protected void login(User user) {
        homePageAssertion();


        driver.findElement(By.xpath("//div[contains(@class, 'profile')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'name')]")).sendKeys(user.getUserName());
        driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();

        userNameAssersion(user);
    }

    //Common Assertions
    public void homePageAssertion() {
        assertEquals(driver.getTitle(), UIElements.HOME_PAGE.getUIelement());
    }

    public void userNameAssersion(User user) {
        assertEquals(driver.findElement(By.id("user-name")).getText(), user.getUserCredentials());
    }

}
