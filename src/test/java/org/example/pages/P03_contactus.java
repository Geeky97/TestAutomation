package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_contactus {

    public P03_contactus () {
        PageFactory.initElements(Hooks.driver, this);
    }

    // Page elements
    @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
    public WebElement homePageLogo;

        @FindBy(xpath = "//a[@href=\"/contact_us\"]")
                public WebElement contactUsLink;

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    public WebElement getInTouchHeader;

    @FindBy(name = "name")
    public WebElement nameField;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "subject")
    public WebElement subjectField;

    @FindBy(name = "message")
    public WebElement messageField;

    @FindBy(name = "upload_file")
    public WebElement uploadFile;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public WebElement okBtn;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[@href='/']")
    public WebElement homeBtn;



    // Method for clicking on Contact Us button and verifying "GET IN TOUCH"
    public void navigateToContactUs(){
        contactUsLink.click();
        assert getInTouchHeader.isDisplayed();
    }

    // Method to enter all contact details, upload a file, and submit the form
    public void submitContactUsForm(String name, String email, String subject, String message , String filepath){
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
        uploadFile.sendKeys(filepath);
        submitBtn.click();
    }

    // Handle alert and verify success message
    public boolean verifySubmissionSuccess() {
        Hooks.driver.switchTo().alert().accept();  // Accept alert
        return successMessage.getText().contains("Success! Your details have been submitted successfully.");
    }

    // Method to verify home page visibility and return home
    public void returnToHomePage() {
        homeBtn.click();
        assert homePageLogo.isDisplayed();
    }

}
