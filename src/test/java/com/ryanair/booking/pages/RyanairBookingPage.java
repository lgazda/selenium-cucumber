package com.ryanair.booking.pages;

import com.ryanair.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RyanairBookingPage extends BasePage {
    @FindBy(how = How.CSS, using = "div[class=\"flight-header__min-price hide-mobile\"] flights-table-price div div")
    private WebElement firstPriceOffer;

    @FindBy(how = How.ID, using = "continue")
    private WebElement continueButton;

    @FindBy(how = How.CSS, using = "button[class=\"core-btn-primary core-btn-block core-btn-medium btn-text\"]")
    private WebElement checkoutButton;

    @FindBy(how = How.CSS, using = "div[class=\"flights-table-fares__head\"] span[translate=\"trips.flight_list_table.table_heading.regular-fare\"]")
    private WebElement priceListTableHeader;

    @FindBy(how = How.CSS, using = "footer[ui-view=\"footerView\"]")
    private WebElement footer;

    @FindBy(how = How.CSS, using = "button[class=\"core-btn-ghost seat-prompt-popup-footer-btn\"]")
    private WebElement okThanksButton;


    public RyanairBookingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RyanairBookingPage selectFirstPriceOffer() {
        waitForClickableElement(firstPriceOffer);
        firstPriceOffer.click();
        return this;
    }

    public RyanairBookingPage selectStandard() {
        waitForClickableElement(continueButton);
        waitForClickableElement(priceListTableHeader);
        waitForClickableElement(footer);
        continueButton.click();
        return this;
    }

    public RyanairBookingPage clickContinueButton() {
        click(continueButton);
        return this;
    }

    public RyanairPaymentPage clickCheckoutButton() {
        click(checkoutButton);
        click(okThanksButton);
        return new RyanairPaymentPage(driver);
    }
}
