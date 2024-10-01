package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;


public class D02_LogStepDefs {
    P02_login login = new P02_login();
    //valid credentials
    public String validemail = "sayedkhaledhhns@yahoo.com";
    private String validpassword = "1541997";
    private String name = "Sayed Khaledhh";

    private String validemail2 = "shady@waffraha.com";
    private String validpassword2 = "1541997";
    private String name2 = "shady";




    //invalid credentials
    private String invalidEmail = "invalid@example.com";
    private String invalidPassword = "wrongpassword";


    //private String password = "1541997";

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        login.homePageIsVisible.isDisplayed();
    }

    @When("The user clicks on the Signup_Login button")
    public void theUserClicksOnTheSignup_LoginButton() {
        login.signupLoginBtn.click();
    }

    @Then("The Login to your account page should be_visible")
    public void theLoginToYourAccountPageShouldBeVisible() {
        login.LoginToYourAccount.isDisplayed();
    }
    @When("User enter valid email address & password")
    public void userEnterValidEmailAddressPassword() {
        login.Email.sendKeys(validemail);
        login.Password.sendKeys(validpassword);
    }


    @And("The user clicks the login button")
    public void theUserClicksTheLoginButton() {
        login.LoginBtn.click();
    }

    @Then("User should be visible Logged in as username")
    public void userShouldBeVisibleLoggedInAsUsername() {
        String loggedInAsName = login.loggedInAsName.getText();
        System.out.println(loggedInAsName);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loggedInAsName.contains("Logged in as " + name));

        // Trigger the assertions
        softAssert.assertAll();
    }


    @When("User enters incorrect email address & password")
    public void userEntersIncorrectEmailAddressPassword() {
        login.Email.sendKeys(invalidEmail);
        login.Password.sendKeys(invalidPassword);
    }


    @Then("Verify error Your email or password is incorrect! is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        SoftAssert soft = new SoftAssert();
        // 1- get text and check the text is visible
        soft.assertTrue(login.IncorrectEmailOrPassword.getText().contains("Your email or password is incorrect!"));

        //get css value and verify color is #FE980F hex
        String color = login.IncorrectEmailOrPassword.getCssValue("color");
        //Color.FromString(actualcolor).asHex();
        soft.assertEquals(Color.fromString(color).asHex(),"#ff0000");
        soft.assertAll();


    }

    @And("The user clicks the logout button")
    public void theUserClicksTheLogoutButton() {
        login.logoutBtn.click();
    }

    @Then("Verify user is navigated to login page")
    public void verifyUserIsNavigatedToLoginPage() {
        boolean isLoginPageVisible = login.LoginToYourAccount.isDisplayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLoginPageVisible, "User is not navigated to the login page after logout");
        softAssert.assertAll();
    }
}


