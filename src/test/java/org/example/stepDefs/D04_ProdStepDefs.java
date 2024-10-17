package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_products;
import org.example.Services.ValidationService;

import org.testng.asserts.SoftAssert;

public class D04_ProdStepDefs {
    P04_products product = new P04_products();
    SoftAssert softAssert = new SoftAssert();
    ValidationService validationServiceObject = new ValidationService();
    public String typeOfClass = "Product";


    @When("User clicks 'Products'")
    public void userClicksProducts() {
        product.ClickProductsButton();
    }

    @Then("ALL PRODUCTS page is displayed")
    public void allPRODUCTSPageIsDisplayed() {
        softAssert.assertTrue(product.isAllProductsPageVisible(), "All products page is not displayed");
        softAssert.assertAll();
    }

    @And("The products list is visible")
    public void theProductsListIsVisible() {
        softAssert.assertTrue(product.isProductDetailsVisible(), "Product details is not visible");
        softAssert.assertAll();
    }

    @When("User clicks View Product for the first item")
    public void userClicksViewProductForTheFirstItem() {
        product.clickOnViewFirstProduct();
    }

    @Then("Product detail page is displayed with all product details")
    public void productDetailPageIsDisplayedWithAllProductDetails() {
        softAssert.assertTrue(product.isProductDetailVisible(), "Product details are not fully visible.");
        softAssert.assertAll();
        // Call the method to print product details
        userVerifiesProductDetails();
    }

    public void userVerifiesProductDetails() {
        // Get product details
        String name = product.getProductName();
       validationServiceObject.stringValidation(name,typeOfClass);

        String availability = product.getProductAvailability();
        validationServiceObject.stringValidation(availability, typeOfClass);

        String condition = product.getProductCondition();
        validationServiceObject.stringValidation(condition, typeOfClass);

        String brand = product.getProductBrand();
        validationServiceObject.stringValidation(brand, typeOfClass);

        String category = product.getProductCategory();
        validationServiceObject.stringValidation(category, typeOfClass);

        // New method
        validationServiceObject.integerValidation(product.getProductPrice(),typeOfClass,"both",400,3000);
        validationServiceObject.integerValidation(product.getProductQuantity(),typeOfClass,"both",1,10);
    }

    @And("Enters a product name in the search input and clicks the search button")
    public void entersAProductNameInTheSearchInputAndClicksTheSearchButton() {
            product.Clicksearchproduct();
    }

    @Then("The user verifies that SEARCHED PRODUCTS is visible")
    public void theUserVerifiesThatSEARCHEDPRODUCTSIsVisible() {
        softAssert.assertTrue(product.textProductSearchedisVisible(), "'SEARCHED PRODUCTS' is not visible");
        softAssert.assertAll();
    }

    @And("Confirms that the relevant products are displayed")
    public void confirmsThatTheRelevantProductsAreDisplayed() {
        softAssert.assertTrue(product.isProductDetailsVisible(), "Product details are not visible");

    }
}























