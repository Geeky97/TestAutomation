package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class P02_login {

    public P02_login () { PageFactory.initElements(Hooks.driver, this); }

    @FindBy(xpath ="//img[@src='/static/images/home/logo.png']")
    public WebElement homePageIsVisible;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement signupLoginBtn;

    // 'Login to your account' text
    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    public WebElement LoginToYourAccount;

    @FindBy (name = "email")
    public WebElement Email;
    @FindBy (name = "password")
    public WebElement Password;

    // Login button
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement LoginBtn;

    // Logged in as username
    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
    public WebElement loggedInAsName;

    // Incorrect login error message
    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    public WebElement IncorrectEmailOrPassword;

    // Logout button
    @FindBy(xpath = "//a[@href=\"/logout\"]")
    public WebElement logoutBtn;
}
