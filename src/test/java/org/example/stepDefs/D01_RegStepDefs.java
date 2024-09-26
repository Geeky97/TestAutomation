package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;



public class D01_RegStepDefs {
    P01_register register = new P01_register();
    private String generatedName;



    @Given("User is on home page")
    public void userIsOnHomePage() {
    register.homePageIsVisible.isDisplayed();
    }


    @Then("User go to register page")
    public void user_go_to_register_page() {
        register.loginButton.click();

    }


    @When("User enter name & email")
    public void userEnter (){
/*
        Faker fake = new Faker();
        String name = fake.internet().domainName();
        String email = fake.internet().safeEmailAddress();
        register.nameField.sendKeys(name);
        register.emailField.sendKeys(email);
*/
        Faker fake = new Faker();
        generatedName = fake.name().firstName();  // Store the generated name in the variable
        String email = fake.internet().safeEmailAddress();

        // Use the generated name and email to fill the form
        register.nameField.sendKeys(generatedName);
        register.emailField.sendKeys(email);
    }


    @And("Click sign up button")
    public void clickSignUpButton() {
        register.signupButton.click();
    }


    @Then("User should see ENTER ACCOUNT INFORMATION visible")
    public void userShouldSeeENTERACCOUNTINFORMATIONVisible() {
        SoftAssert soft = new SoftAssert();
        // 1- get text and check the text is visible
        soft.assertTrue(register.SignupInformation.getText().contains("ENTER ACCOUNT INFORMATION"));
        //get css value and verify color is #FE980F hex
        String actualcolor =  register.SignupInformation.getCssValue("color");
        //Color.FromString(actualcolor).asHex();
        soft.assertEquals(Color.fromString(actualcolor).asHex(),"#fe980f");
        soft.assertAll();
    }


    @When("User select title")
    public void userSelectTitle() {
        register.Gender1.click();


    }

    @And("User fills account information with name, email, password, and DOB")
    public void userFillsAccountInformationWithNameEmailPasswordAndDOB() {
        //register.name.sendKeys("kkkkk");
        //register.email.sendKeys("kkkkk@gmail.com");
        register.password.sendKeys("kkkkk");
        register.days.sendKeys("15");
        register.months.sendKeys("12");
        register.years.sendKeys("2000");

    }


    @And("User selects Sign up for our newsletter! checkbox")
    public void userSelectsSignUpForOurNewsletterCheckbox() {
        register.CheckBoxNewsletter.click();
    }

    @And("User selects Receive special offers from our partners! checkbox")
    public void userSelectsReceiveSpecialOffersFromOurPartnersCheckbox() {
        register.CheckBoxOptin.click();
    }


    @And("User fills personal details First name, Last name, Company, Address, Address{int}, Country, State, City, Zipcode, Mobile Number")
    public void userFillsPersonalDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber(int arg0) {
        register.firstNameField.sendKeys("John");
        register.lastNameField.sendKeys("Doe");
        register.companyField.sendKeys("DoeTech");
        register.addressField.sendKeys("123 Main St");
        register.address2Field.sendKeys("Apt 4B");
        register.countryDropdown.sendKeys("United States");
        register.stateField.sendKeys("California");
        register.cityField.sendKeys("California");
        register.zipcodeField.sendKeys("90001");
        register.mobileNumberField.sendKeys("1234567890");

    }

    @And("User clicks Create Account button")
    public void userClicksCreateAccountButton() {
        register.createAccountButton.click();

    }

    @Then("ACCOUNT CREATED! should be visible")
    public void accountCREATEDShouldBeVisible() {
        SoftAssert soft = new SoftAssert();
        // 1- get text and check the text is visible
        String actualcolor;
        soft.assertTrue(register.accountCreatedText.getText().contains("ACCOUNT CREATED!"));
        //get css value and verify color is #FE980F hex
        actualcolor = register.accountCreatedText.getCssValue("color");
        System.out.println(Color.fromString(actualcolor).asHex());
        //Color.FromString(actualcolor).asHex();
        soft.assertEquals(Color.fromString(actualcolor).asHex(),"#008000");
        soft.assertAll();
    }

    @When("User clicks Continue button")
    public void userClicksContinueButton() {
        register.continueButton.click();
    }


    @Then("Logged in as username should be visible")
    public void loggedInAsUsernameShouldBeVisible() {
        String loggedInText = register.loggedInAsText.getText();
        System.out.println("Text from the page: " + loggedInText);

        // Use the generatedName variable for the assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(loggedInText.contains("Logged in as " + generatedName),
                "The expected text 'Logged in as " + generatedName + "' is not visible!");

        soft.assertAll();

    }

    @When("User clicks Delete Account button")
    public void userClicksDeleteAccountButton() {
        register.deleteAccountButton.click();

    }

    @Then("ACCOUNT DELETED! should be visible")
    public void accountDELETEDShouldBeVisible() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.accountDeletedText.getText().contains("ACCOUNT DELETED!"));
        soft.assertAll();
    }

}



