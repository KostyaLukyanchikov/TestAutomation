package tests.selenium.steps;


import configuration.AppConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springBddProject.qa.gui.services.enums.LoginUser;
import org.springBddProject.qa.gui.services.enums.UIElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;


@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public abstract class BaseTest {

    @Autowired
    @Lazy
    protected WebDriver driver;

    @Value("${site.url}")
    protected String epamUrl;

    @BeforeClass
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.get(epamUrl);
    }

    @After
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
