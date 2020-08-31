package test.selenium;

import enums.LoginUser;
import enums.UIElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

@ContextConfiguration
public abstract class BaseTest {

    protected WebDriver driver;

    @Autowired
    String epamUrl;

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
        homePageAssertion();

        driver.findElement(By.xpath("//div[contains(@class, 'profile')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'name')]")).sendKeys(loginUser.getName());
        driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys(loginUser.getPassword());
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();

        userNameAssersion(loginUser);
    }

    //Common Assertions
    public void homePageAssertion() {
        assertEquals(driver.getTitle(), UIElements.HOME_PAGE.getUiElement());
    }

    public void userNameAssersion(LoginUser loginUser) {
        assertEquals(driver.findElement(By.id("user-name")).getText(), loginUser.getCredentials());
    }

}
