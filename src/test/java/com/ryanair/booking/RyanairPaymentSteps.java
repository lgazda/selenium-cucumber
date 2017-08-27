package com.ryanair.booking;

import com.ryanair.BaseTest;
import com.ryanair.booking.pages.RyanairBookingPage;
import com.ryanair.booking.pages.RyanairPaymentPage;
import com.ryanair.booking.pages.RyanairStartPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertTrue;

public class RyanairPaymentSteps extends BaseTest {
    private static final String ryanairPageURL = "https://www.ryanair.com/ie/en/";
    private static final String userEmail = "ryanair123@mailinator.com";
    private static final String userPassword = "Ry@n@ir123";
    private static final String userLastName = "LastName";
    private static final String userFirstName = "FirstName";
    private static final String userPhoneNumber = "600600600";
    private static final String userAddress1 = "userAddress1";
    private static final String userAddress2 = "userAddress2";
    private static final String userCity = "userCity";
    private static final String userZipCode = "userZipCode";
    private static final String userCardHolderName = "CardHolderName";

    private RyanairStartPage ryanairStartPage = null;
    private RyanairBookingPage ryanairBookingPage = null;
    private RyanairPaymentPage ryanairPaymentPage = null;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Given("^I am on Ryanair start page")
    public void navigateToRyanairStartPage() {
        driver.get(ryanairPageURL);
        ryanairStartPage = new RyanairStartPage(driver);
    }

    @And("^I search for a flight from (.*) to (.*) on (.*)-(.*)-(.*)$")
    public void makeBooking(String departureAirport, String destinationAirport, String flyOutDay, String flyOutMonth, String flyOutYear) throws Throwable {
        ryanairBookingPage = ryanairStartPage.clickOneWayRadio()
            .enterDepartureAirport(departureAirport)
            .enterDestinationAirport(destinationAirport)
            .clickContinueButton()
            .clickContinueButton()//TODO fix
            .enterFlyOutDate(flyOutDay, flyOutMonth, flyOutYear)
            .clickLetsGoButton();
    }

    @And("^I pick a first offer$")
    public void pickFirstOffer() {
        ryanairBookingPage.selectFirstPriceOffer()
            .selectStandard()
            .clickContinueButton();
    }

    @And("^I do a check out$")
    public void doCheckout() {
        ryanairPaymentPage = ryanairBookingPage.clickCheckoutButton();
    }

    @And("^I am trying to do a payment as logged user$")
    public void tryToDoPayment() {
        ryanairPaymentPage.clickLoginButton()
            .logInUser(userEmail, userPassword);
    }

    @And("^I insert a valid contact data$")
    public void insertValidContactData()  {
        ryanairPaymentPage.enterContactDetails(userPhoneNumber);
    }

    @And("^I insert a valid billing data$")
    public void insertValidBillingData() {
        ryanairPaymentPage.enterBillingAddress(userAddress1, userAddress2, userCity, userZipCode);
    }

    @And("^I insert a valid passenger data$")
    public void insertValidPassengerData() {
        ryanairPaymentPage.enterPassengerDetails(userFirstName, userLastName);
    }

    @And("^I insert payment details with card number '(.*)' and security code '(.*)'$")
    public void insertPaymentData(String userCardNumber, String userSecurityCode) {
        ryanairPaymentPage.enterPaymentDetails(userCardNumber, userCardHolderName, userSecurityCode);
    }

    @And("^I make a payment")
    public void makePayment() {
        ryanairPaymentPage.clickAcceptPolicy()
            .clickPayNowButton();
    }

    @Then("^I should see payment declined error")
    public void assertPaymentDeclineErrorMessage(){
        assertTrue("Payment decline error message is not displayed", ryanairPaymentPage.getPaymentErrorMessage().isDisplayed());
    }
}


