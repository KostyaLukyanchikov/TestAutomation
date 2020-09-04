package org.springBddProject.qa.gui.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaslang.API;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springBddProject.qa.gui.services.webdriver.WrappedWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static javaslang.API.Match;

@Configuration
public class WebDriverConfig {
    private final String CHROME = "Chrome";

    @Value("${webdriver.browser:Chrome}")
    private String browserName;


    @Bean(destroyMethod = "close")
    public WrappedWebDriver webDriver() throws IOException {
        return Match(browserName).of(
                API.Case(CHROME::equalsIgnoreCase, this::initChrome)
        );
    }

    private WrappedWebDriver initChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return new WrappedWebDriver(driver);
    }
}