package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {


    public P01_register ()
    {
        PageFactory.initElements(Hooks.driver , this);
    }

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement loginButton;

    // Home page visibility
    @FindBy(xpath ="//img[@src='/static/images/home/logo.png']")
    public WebElement homePageIsVisible;

    // Home page and Sign Up elements
    @FindBy(xpath = "//input[@placeholder=\"Name\"]")
    public WebElement nameField;
    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    public WebElement emailField;
    // Signup/Login button
    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    public WebElement signupButton;

    // Account information elements
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement SignupInformation;
    @FindBy (xpath = "//input[@id=\"id_gender1\"]")
    public WebElement Gender1;
    @FindBy (id="name")
    public WebElement name;
    @FindBy (id="email")
    public WebElement email;
    @FindBy (id="password")
    public WebElement password;
    @FindBy (id="days")
    public WebElement days;
    @FindBy (id="months")
    public WebElement months;
    @FindBy (id="years")
    public WebElement years;
    @FindBy (id="newsletter")
    public WebElement CheckBoxNewsletter;
    @FindBy (id="optin")
    public WebElement CheckBoxOptin;

    // Personal details
    @FindBy(id = "first_name")
    public WebElement firstNameField;

    @FindBy(id = "last_name")
    public WebElement lastNameField;

    @FindBy(id = "company")
    public WebElement companyField;

    @FindBy(id = "address1")
    public WebElement addressField;

    @FindBy(id = "address2")
    public WebElement address2Field;

    @FindBy(id = "country")
    public WebElement countryDropdown;

    @FindBy(id = "state")
    public WebElement stateField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "zipcode")
    public WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberField;

    @FindBy (xpath = "//button[@data-qa=\"create-account\"]")
    public WebElement createAccountButton;

    // Confirmation elements
    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedText;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;
    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
    public WebElement loggedInAsText;
    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    public WebElement deleteAccountButton;
    @FindBy(xpath ="//b[contains(text(),'Account Deleted!')]" )
    public WebElement accountDeletedText;

    // 'New User Signup!' text
    @FindBy(xpath = "//h2[contains(text(), 'New User Signup!')]")
    public WebElement NewUserSignup;

    @FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
    public WebElement emailExistsErrorMessage;



















/*
    public WebElement register_page()
    {
        WebElement register = Hooks.driver.findElement(By.xpath("//a[@href=\"/login\"]"));
        return register;
    }

 */
}
