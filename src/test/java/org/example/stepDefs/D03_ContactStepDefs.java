package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_contactus;
import org.testng.asserts.SoftAssert;

public class D03_ContactStepDefs {
    P03_contactus contactus = new P03_contactus();
    SoftAssert softAssert = new SoftAssert();


   private String name = "Sayed Khaledhh";
   private String email = "sayedkhaledhhns@yahoo.com";
   private String subject = "sdads";
   private String message = "dsdasd";
   private String filePath = "E:\\Download\\777.jpg";

    @When("User navigates to Contact Us page")
    public void user_navigates_to_contact_us_page() {
        contactus.navigateToContactUs();
    }

    @And("User submits contact form")
    public void userSubmitsContactForm() {
        contactus.submitContactUsForm(name, email, subject, message, filePath);
    }


    @Then("Verify success message is displayed")
    public void verifySuccessMessageIsDisplayed() {
        softAssert.assertTrue(contactus.verifySubmissionSuccess(), "Success message is not visible");
        softAssert.assertAll();
    }

    @And("User returns to home page")
    public void userReturnsToHomePage() {
        contactus.returnToHomePage();
    }
}
