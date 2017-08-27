package com.ryanair.booking.pages;

import com.ryanair.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class RyanairStartPage extends BasePage {
    @FindBy(how = How.ID, using = "lbl-flight-search-type-one-way")
    private WebElement oneWayRadio;
    @FindBy(how = How.CSS, using = "input[placeholder=\"Departure airport\"]")
    private WebElement departureAirportInput;
    @FindBy(how = How.CSS, using = "input[placeholder=\"Destination airport\"]")
    private WebElement destinationAirportInput;
    @FindBy(how = How.CSS, using = "button[class=\"core-btn-primary core-btn-block core-btn-big\"]")
    private WebElement continueButton;
    @FindBy(how = How.CSS, using = "input[name=\"dateInput0\"]")
    private WebElement flyOutDayInput;
    @FindBy(how = How.CSS, using = "input[name=\"dateInput1\"]")
    private WebElement flyOutMonthInput;
    @FindBy(how = How.CSS, using = "input[name=\"dateInput2\"]")
    private WebElement flyOutYearInput;
    @FindBy(how = How.CSS, using = "button[class=\"core-btn-primary core-btn-block core-btn-big\"]")
    private WebElement letsGoButton;



    public RyanairStartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RyanairStartPage clickOneWayRadio() {
        click(oneWayRadio);
        return new RyanairStartPage(driver);
    }

    public RyanairStartPage enterDepartureAirport(String departureAirport) {
        departureAirportInput.clear();
        departureAirportInput.sendKeys(departureAirport);
        return this;
    }

    public RyanairStartPage enterDestinationAirport(String destinationAirport) {
        destinationAirportInput.sendKeys(destinationAirport);
        return this;
    }

    public RyanairStartPage clickContinueButton() {
        click(continueButton);
        return new RyanairStartPage(driver);
    }

    public RyanairStartPage enterFlyOutDate(String flyOutDay, String flyOutMonth, String flyOutYear) {
        waitForClickableElement(flyOutDayInput);
        flyOutDayInput.sendKeys(flyOutDay);
        flyOutMonthInput.sendKeys(flyOutMonth);
        flyOutYearInput.sendKeys(flyOutYear);
        return this;
    }

    public RyanairBookingPage clickLetsGoButton() {
        click(letsGoButton);
        return new RyanairBookingPage (driver);
    }
}
