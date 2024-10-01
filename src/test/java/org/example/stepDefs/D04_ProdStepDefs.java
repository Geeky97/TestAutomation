package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_products;
import org.testng.asserts.SoftAssert;

public class D04_ProdStepDefs {
    P04_products products = new P04_products();
    SoftAssert softAssert = new SoftAssert();

    @When("User clicks 'Products'")
    public void userClicksProducts() {
        products.ClickProductsButton();
    }

    @Then("ALL PRODUCTS page is displayed")
    public void allPRODUCTSPageIsDisplayed() {
        softAssert.assertTrue(products.isAllProductsPageVisible(), "All products page is not displayed");
        softAssert.assertAll();
    }

    @And("The products list is visible")
    public void theProductsListIsVisible() {
        softAssert.assertTrue(products.isProductDetailsVisible(), "Product details is not visible");
        softAssert.assertAll();
    }

    @When("User clicks View Product for the first item")
    public void userClicksViewProductForTheFirstItem() {
        products.clickOnViewFirstProduct();
    }

    @Then("Product detail page is displayed with all product details")
    public void productDetailPageIsDisplayedWithAllProductDetails() {
        softAssert.assertTrue(products.isProductDetailVisible(), "Product details are not fully visible.");
        softAssert.assertAll();

        // Call the method to print product details
        userVerifiesProductDetails();
    }

    public void userVerifiesProductDetails() {
        // Get product details
        String name = products.getProductName();
        int price = products.getProductPrice();
        String availability = products.getProductAvailability();
        String condition = products.getProductCondition();
        String brand = products.getProductBrand();
        String category = products.getProductCategory();
        int quantity = products.getProductQuantity();







        // Verify that details are visible and meet the conditions
        if (name != null && !name.isEmpty()) {
            System.out.println("Product Name: " + name);
        } else {
            System.out.println("Product Name is not visible!");
        }

        if (price >=50) {
            System.out.println("Product Price: " + price);
        } else {
            System.out.println("Product Price is not visible!");
        }

        if (availability != null && !availability.isEmpty()) {
            System.out.println("Product Availability: " + availability);
        } else {
            System.out.println("Product Availability is not visible!");
        }

        if (condition != null && !condition.isEmpty()) {
            System.out.println("Product Condition: " + condition);
        } else {
            System.out.println("Product Condition is not visible!");
        }

        if (brand != null && !brand.isEmpty()) {
            System.out.println("Product Brand: " + brand);
        } else {
            System.out.println("Product Brand is not visible!");
        }

        if (category != null && !category.isEmpty()) {
            System.out.println("Product Category: " + category);
        } else {
            System.out.println("Product Category is not visible!");
        }

        if (quantity >= 1) {
            System.out.println("Product Quantity: " + quantity);
        } else {
            System.out.println("Product Quantity is not visible!");
        }
    }


}






















