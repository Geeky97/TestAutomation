package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_products {
    public P04_products() {
        PageFactory.initElements(Hooks.driver, this);
    }

    // Products button
    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsButton;

    // All Products Header
    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    public WebElement allProductsPageHeader;

    //Product list
    @FindBy(xpath = "//div[@class='features_items']")
    public WebElement productsList;

    // Click Product button (first product)
    @FindBy(css = "a[href='/product_details/1']")
    public WebElement viewFirstProductButton;

    // Product details on the product detail page
    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category')]")
    public WebElement productCategory;

    @FindBy(xpath = "//span[contains(text(), 'Rs. ')]")
    public WebElement productPrice;

    @FindBy(xpath = "//b[contains(text(),'Availability')]")
    public WebElement productAvailability;

    @FindBy(xpath = "//b[contains(text(),'Condition')]")
    public WebElement productCondition;

    @FindBy(xpath = "//b[contains(text(),'Brand')]")
    public WebElement productBrand;

    @FindBy(id = "quantity")
    public WebElement productQuantity;




    public void ClickProductsButton() {
        productsButton.click();
    }

    public boolean isAllProductsPageVisible() {
        return allProductsPageHeader.isDisplayed();
    }

    public boolean isProductDetailsVisible() {
        return productsList.isDisplayed();
    }

    public void clickOnViewFirstProduct(){
        viewFirstProductButton.click();
    }

    public boolean isProductDetailVisible(){
        return  productName.isDisplayed() &&
                productCategory.isDisplayed() &&
                productPrice.isDisplayed() &&
                productAvailability.isDisplayed() &&
                productCondition.isDisplayed() &&
                productBrand.isDisplayed();

    }

    public String getProductName(){
        return productName.getText();
    }

    public int getProductPrice() {
        // Remove "Rs. " from the price string and trim any extra spaces
        String priceText = productPrice.getText().replaceAll("[^\\d]", ""); // This keeps only digits
        return Integer.parseInt(priceText); // Convert the cleaned string to an integer
    }

        public String getProductAvailability(){
            return productName.getText();
        }

    public String getProductCondition(){
        return productCondition.getText();
    }

    public String getProductBrand(){
        return productBrand.getText();
    }

    public String getProductCategory(){
        return productCategory.getText();
    }

    public int getProductQuantity() {
        String quantityValue = productQuantity.getAttribute("value");
        return Integer.parseInt(quantityValue);


    }


}



















