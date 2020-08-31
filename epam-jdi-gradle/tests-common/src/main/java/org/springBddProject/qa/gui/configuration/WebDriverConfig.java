package org.springBddProject.qa.gui.configuration;


import org.springBddProject.qa.gui.services.webdriver.WrappedWebDriver;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static javaslang.API.Case;
import static javaslang.API.Match;


@Configuration
public class WebDriverConfig {
    private final String CHROME = "Chrome";

    @Value("${webdriver.brower:Chrome}")
    private String browserName;

    @Bean(destroyMethod = "quit")
    public WrappedWebDriver webDriver() throws IOException {
        return Match(browserName).of(
                Case(CHROME::equalsIgnoreCase, this::initChrome)
        );
    }

    private WrappedWebDriver initChrome() {
        ChromeDriverManager.getInstance(DriverManagerType.valueOf(CHROME)).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return new WrappedWebDriver(driver);
    }
}
