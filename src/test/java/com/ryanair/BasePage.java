package com.ryanair;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForClickableElement(WebElement webElement){
        sleep(); //Twmporary solusion, should be improved
        driverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void click(WebElement webElement) {
        waitForClickableElement(webElement);
        webElement.click();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriverWait driverWait() {
        return new WebDriverWait(driver, 30);
    }
}
