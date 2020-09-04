package org.springBddProject.qa.gui.services.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

import static java.lang.String.valueOf;


public class WrappedWebDriver extends EventFiringWebDriver {
    private static final String LOG_EXECUTION_TIME = "{} Execution_Time(ms):; {}; Page_URL:; {};";

    private static WebDriver driver;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public WrappedWebDriver(WebDriver driver) {
        super(driver);
        WrappedWebDriver.driver = driver;
    }

    public WebDriver getWrappedDriver(){
        return driver;
    }


    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            driver.close();
        }
    };

    static {
        ChromeOptions capabilities = new ChromeOptions();
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }


    @Override
    public void get(String s) {
        LOG.debug("Opening url: {}", s);
        long startTime = System.currentTimeMillis();
        try {
            driver.get(s);
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Open_Page",getExecutionTime(startTime), s);
        }
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        LOG.debug("Finding elements by: {}", by);
        long startTime = System.currentTimeMillis();
        try {
            return driver.findElements(by);
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Find_Elements",getExecutionTime(startTime), driver.getCurrentUrl());
        }
    }

    @Override
    public WebElement findElement(By by) {
        LOG.debug("Finding element by: {} ", by);
        long startTime = System.currentTimeMillis();
        try {
            return driver.findElement(by);
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Find_Element",getExecutionTime(startTime), driver.getCurrentUrl());
        }
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        LOG.debug("Driver close");
        long startTime = System.currentTimeMillis();
        try {
            driver.close();
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Driver_Close",getExecutionTime(startTime), "");
        }
    }


    @Override
    public void quit() {
        LOG.debug("Driver quit");
        long startTime = System.currentTimeMillis();
        try {
            driver.quit();
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Driver_Quit",getExecutionTime(startTime), "");
        }
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    /**
     * Take screenshot of the page
     * @return byte array
     */
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Get execution time of action
     * @param startTime - start time
     * @return execution time im ms
     */
    private String getExecutionTime(long startTime){
        return valueOf(System.currentTimeMillis() - startTime);
    }

}
