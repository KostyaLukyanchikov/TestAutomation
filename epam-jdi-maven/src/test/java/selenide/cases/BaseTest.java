package selenide.cases;

import com.codeborne.selenide.Configuration;
import enums.LoginUser;
import enums.UIElements;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseTest {

    protected Properties propValues = PropertyReader.getInstance();
    protected String epamUrl = propValues.getProperty("url");

    @BeforeMethod
    public void setUp() {
        Configuration.pollingInterval = 500;
        Configuration.timeout = 5000;
        Configuration.reportsFolder = "target/selenide/reports/test";
        open(epamUrl);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    //Common Assertions
    public void pageTitleAssertion(UIElements uiElement) {
        assertEquals(title(), uiElement.getUiElement());
    }

    public void userNameAssersion(LoginUser loginUser) {
        assertEquals(element(By.id("user-name")).getText(), loginUser.getCredentials());
    }

    public void serviceContentAssertion(List<String> actualServiceContent, List<String> expectedServiceContend) {
        assertTrue(actualServiceContent.containsAll(expectedServiceContend));
    }

}
