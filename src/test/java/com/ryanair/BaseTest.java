package com.ryanair;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected WebDriver driver;

    public void setUp() throws Exception {
        driver = getChromeClasspathDriver();
        driver.manage().window().maximize();
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

