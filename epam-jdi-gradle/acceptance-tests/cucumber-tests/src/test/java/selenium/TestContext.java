package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TestContext {

    //private static WrappedWebDriver driver;
    @Autowired
    @Lazy
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        this.driver = new ChromeDriver();
    }

    public void setDriver(WebDriver driver) {
        System.out.println("DRIVER URL" + driver.getCurrentUrl());
        this.driver = driver;
    }

}
