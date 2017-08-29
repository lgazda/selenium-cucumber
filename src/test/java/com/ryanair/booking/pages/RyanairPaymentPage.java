package com.ryanair.booking.pages;

import com.ryanair.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RyanairPaymentPage extends BasePage {
    @FindBy(how = How.CSS, using = "button[class=\"core-btn-secondary\"]")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = "input[name=\"emailAddress\"][type=\"email\"")
    private WebElement emailInput;

    @FindBy(how = How.CSS, using = "input[name=\"password\"")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "button[type=\"submit\"]")
    private WebElement submitButton;

    //Passenger details
    @FindBy(how = How.CSS, using = "select[ng-model=\"passenger.name.title\"]")
    private WebElement titleDropdown;

    @FindBy(how = How.CSS, using = "option[label=\"Mr\"]")
    private WebElement titleMr;

    @FindBy(how = How.CSS, using = "input[ng-model=\"passenger.name.first\"]")
    private WebElement firstNameInput;

    @FindBy(how = How.CSS, using = "input[ng-model=\"passenger.name.last\"]")
    private WebElement lastNameInput;

    //Contact details
    @FindBy(how = How.CSS, using = "select[name=\"phoneNumberCountry\"]")
    private WebElement phoneNumberCountryDropdown;

    @FindBy(how = How.CSS, using = "option[label=\"Poland\"]")
    private WebElement countryPoland;

    @FindBy(how = How.CSS, using = "input[name=\"phoneNumber\"]")
    private WebElement phoneNumberInput;

    //Payment method
    @FindBy(how = How.NAME, using = "cardNumber")
    private WebElement cardNumberInput;

    @FindBy(how = How.NAME, using = "cardType")
    private WebElement cardTypeDropdown;

    @FindBy(how = How.CSS, using = "option[label=\"MasterCard\"]")
    private WebElement cardTypeMasterCard;

    @FindBy(how = How.CSS, using = "option[label=\"10\"]")
    private WebElement expiryMonth10;

    @FindBy(how = How.CSS, using = "option[label=\"2018\"]")
    private WebElement expiryYear2018;

    @FindBy(how = How.NAME, using = "securityCode")
    private WebElement securityCodeInput;

    @FindBy(how = How.NAME, using = "cardHolderName")
    private WebElement cardHolderNameInput;

    //Billing Address
    @FindBy(how = How.ID, using = "billingAddressAddressLine1")
    private WebElement address1Input;
    @FindBy(how = How.ID, using = "billingAddressAddressLine2")
    private WebElement address2Input;
    @FindBy(how = How.ID, using = "billingAddressCity")
    private WebElement cityInput;
    @FindBy(how = How.ID, using = "billingAddressPostcode")
    private WebElement zipCodeInput;
    @FindBy(how = How.ID, using = "billingAddressCountry")
    private WebElement billingAddressCountryDropdown;
    @FindBy(how = How.CSS, using = "option[label=\"Poland\"]")
    private WebElement countryPolandBilling;

    //Accept policy and terms
    @FindBy(how = How.NAME, using = "acceptPolicy")
    private WebElement acceptPolicyRadio;

    //Pay now
    @FindBy(how = How.CSS, using = "button[class=\"core-btn-primary core-btn-medium\"]")
    private WebElement payNowButton;

    //Payment error message
    @FindBy(how = How.CSS, using = "prompt[text=\"common.components.payment_forms.error_explain_declined\"]")
    private WebElement paymentErrorMessage;

    public RyanairPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RyanairPaymentPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    public RyanairPaymentPage logInUser(String userEmail, String userPassword) {
        waitForClickableElement(submitButton);
        emailInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        submitButton.click();
        return this;
    }

    public RyanairPaymentPage enterPassengerDetails(String userFirstName, String userLastName) {
        click(titleDropdown);
        click(titleMr);
        firstNameInput.sendKeys(userFirstName);
        lastNameInput.sendKeys(userLastName);
        return this;
    }

    public RyanairPaymentPage enterContactDetails(String userPhoneNumber){
        click(countryPoland);
        phoneNumberInput.sendKeys(userPhoneNumber);
        return this;
    }

    public RyanairPaymentPage enterPaymentDetails(String userCardNumber, String userCardHolderName, String userSecurityCode){
        cardNumberInput.sendKeys(userCardNumber);
        cardTypeDropdown.click();
        click(cardTypeMasterCard);
        click(expiryMonth10);
        click(expiryYear2018);
        securityCodeInput.sendKeys(userSecurityCode);
        cardHolderNameInput.sendKeys(userCardHolderName);
        return this;
    }

    public RyanairPaymentPage enterBillingAddress(String userAddress1, String userAddress2, String userCity, String userZipCode){
        address1Input.sendKeys(userAddress1);
        address2Input.sendKeys(userAddress2);
        cityInput.sendKeys(userCity);
        zipCodeInput.sendKeys(userZipCode);
        click(billingAddressCountryDropdown);
        click(countryPolandBilling);
        return this;
    }

    public RyanairPaymentPage clickAcceptPolicy(){
        Actions actions = new Actions(driver);
        actions.moveToElement(acceptPolicyRadio);
        actions.click();
        actions.perform();
        return this;
    }

    public RyanairPaymentPage clickPayNowButton(){
        click(payNowButton);
        return this;
    }

    public WebElement getPaymentErrorMessage(){
        waitForClickableElement(paymentErrorMessage);
        return driver.findElement(By.cssSelector("prompt[text=\"common.components.payment_forms.error_explain_declined\"]"));
    }
}
