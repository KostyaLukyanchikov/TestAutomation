package selenium;

import configuration.AppConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.springBddProject.qa.gui.configuration.WebDriverConfig;
import org.springBddProject.qa.gui.services.enums.LoginUser;
import org.springBddProject.qa.gui.services.enums.UIElements;
import org.springBddProject.qa.gui.services.webdriver.WrappedWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;


@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public abstract class BaseTest {

    protected WrappedWebDriver driver;

    @Autowired
    @Lazy
    protected WebDriverConfig driverConfig;

    @Value("${site.url}")
    protected String epamUrl;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpBrowser() throws IOException {
        driver = driverConfig.webDriver();
        driver.get(epamUrl);
    }

    @AfterEach
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
