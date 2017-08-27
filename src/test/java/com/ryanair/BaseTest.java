package com.ryanair;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class BaseTest {
    protected WebDriver driver;

    public void setUp() throws Exception {
        setUpDriver();
        driver.manage().window().maximize();
    }

    private void setUpDriver() {
        String chromeDriverPath = System.getProperty("chrome.driver.path");
        String safariDriverPath = System.getProperty("safari.driver.path");

        if(chromeDriverPath != null) {
            driver = getChromeDriver(chromeDriverPath);
        } else if(safariDriverPath != null) {
            driver = getSafariWebDriver(safariDriverPath);
        } else {
            driver = getChromeClasspathDriver();
        }
    }

    private WebDriver getSafariWebDriver(String path) {
        System.setProperty("webdriver.safari.driver", path);
        SafariOptions options = new SafariOptions();
        options.setUseCleanSession(true); //if you wish safari to forget session everytime
        return new SafariDriver(options);
    }

    private WebDriver getChromeDriver(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
    }

    private WebDriver getChromeClasspathDriver() {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        return new ChromeDriver();
    }

    private String getChromeDriverPath (){
        return getClass().getClassLoader().getResource("chromedriver/chromedriver.exe").getPath();
    }

    public void tearDown() throws Exception {
        driver.quit();
    }
}

