package org.example.stepDefs;

import org.example.pages.P05_addcart;
import org.testng.asserts.SoftAssert;
import org.example.Services.ValidationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D05_AddCartStepDefs {
    P05_addcart addcart = new P05_addcart();
    SoftAssert softAssert = new SoftAssert();
    ValidationService validationServiceObject = new ValidationService();
    public String typeOfClass = "quantity";


    @And("User adds the first and second products to the cart")
    public void user_adds_the_first_and_second_products_to_the_cart() throws InterruptedException {
        addcart.addFirstProductToCart();
        Thread.sleep(3000);
        addcart.clickContinueShopping();
        addcart.addSecondProductToCart();
    }

    @Then("User views the cart")
    public void userViewsTheCart() throws InterruptedException {
        Thread.sleep(3000);
        addcart.viewCartItems();
        
    }

    @And("Verifies both products are added with correct details")
    public void verifiesBothProductsAreAddedWithCorrectDetails() {
        //verify first and second items add to cart
        softAssert.assertTrue(addcart.areProductItemsAddToCart(), "Products are not added to the cart");

        // Verify the first product price
        String expectedFirstPrice = "Rs. 500";
        String actualFirstPrice = addcart.getFirstProductPrice();
        softAssert.assertEquals(actualFirstPrice, expectedFirstPrice, "First product price is incorrect.");

        // Verify the second product price
        String expectedSecondPrice = "Rs. 400";
        String actualSecondPrice = addcart.getSecondProductPrice();
        softAssert.assertEquals(expectedSecondPrice, actualSecondPrice, "Second product price is incorrect.");

        // Verify the total price for first and second products
        String actualFirstTotalPrice = addcart.getFirstProductTotalPrice();
        String actualSecondTotalPrice = addcart.getSecondProductTotalPrice();

        System.out.println("First product total: " + actualFirstTotalPrice);
        System.out.println("Second product total: " + actualSecondTotalPrice);

        // Assuming totals are calculated correctly on the website
        softAssert.assertEquals(actualFirstTotalPrice, expectedFirstPrice, "First product total is incorrect.");
        softAssert.assertEquals(actualSecondTotalPrice, expectedSecondPrice, "Second product total is incorrect.");

        softAssert.assertAll();
    }

    @When("User views a product")
    public void userViewsAProduct() {
        addcart.clickViewproductButton();
    }


    @And("User verifies product details are opened")
    public void userVerifiesProductDetailsAreOpened() {
        softAssert.assertTrue(addcart.checkIsPageOpenByQuantityField(), "Product details are not opened");
    }

    @And("User increases quantity to {int}")
    public void userIncreasesQuantityTo(int quantity) {
        addcart.setProductQuantity(quantity);


    }

    @And("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        addcart.clickAddToCart();
    }

    @Then("User verifies the product is displayed with correct quantity")
    public void userVerifiesTheProductIsDisplayedWithCorrectQuantity() {
        int actualQuantity = addcart.getCartProductQuantity();
        softAssert.assertEquals(actualQuantity, 4, "Product quantity in cart is incorrect");
        softAssert.assertAll();
    }
}
