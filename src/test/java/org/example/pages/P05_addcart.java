package org.example.pages;


import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_addcart {
     public P05_addcart() {
         PageFactory.initElements(Hooks.driver, this);
     }

     @FindBy(xpath = "//a[@data-product-id=\"1\"] ")
        public WebElement addFirstProductToCart;

     @FindBy(xpath = "//a[@data-product-id=\"2\"] ")
        public WebElement addSecondProductToCart;

     @FindBy(xpath = ("//button[@class=\"btn btn-success close-modal btn-block\"]"))
        public WebElement continueShoppingButton;

     @FindBy(xpath = "//a[@href='/view_cart']/u[text()='View Cart']")
        public WebElement viewCartButton;

    @FindBy(css = "table[class=\"table table-condensed\"]")
    public WebElement cartItems;

    @FindBy(xpath = "//td[@class=\"cart_price\"]/p[contains(text(), 'Rs. 500')]")
    public WebElement firstProductPrice;

    @FindBy(xpath = "//td[@class=\"cart_price\"]/p[contains(text(), 'Rs. 400')]")
    public WebElement secondProductPrice;

    @FindBy(xpath = "//tr[@id=\"product-1\"]//p[@class=\"cart_total_price\"]")
    public WebElement firstProductTotalPrice;

    @FindBy(xpath = "//tr[@id=\"product-2\"]//p[@class=\"cart_total_price\"]")
    public WebElement secondProductTotalPrice;

    //Scenario 2
    @FindBy(xpath = "//a[@href='/product_details/18']")
    public WebElement viewProductButton;

    @FindBy(xpath = "//input[@id=\"quantity\"]")
    public WebElement quantityField;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[@class=\"disabled\"]")
    public WebElement checkQuantityField;


    public void addFirstProductToCart() {
        addFirstProductToCart.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void addSecondProductToCart() {
        addSecondProductToCart.click();
    }

    public void viewCartItems() {
        viewCartButton.click();
    }

    public boolean areProductItemsAddToCart() {
        return cartItems.isDisplayed();

    }

    public String getFirstProductPrice() {
        return firstProductPrice.getText();
    }

    public String getSecondProductPrice() {
        return secondProductPrice.getText();
    }

    public String getFirstProductTotalPrice() {
        return firstProductTotalPrice.getText();
    }

    public String getSecondProductTotalPrice() {
        return secondProductTotalPrice.getText();
    }

    //scenario 2
    public void clickViewproductButton() {
        viewProductButton.click();
    }

        public boolean checkIsPageOpenByQuantityField() {
        return quantityField.isDisplayed();
        }

    public void setProductQuantity(int quantity){
        quantityField.clear(); // Clear existing value
        quantityField.sendKeys(String.valueOf(quantity));
        System.out.println("Quantity set to: " + quantity);

    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public int getCartProductQuantity() {
        String quantityText = checkQuantityField.getText().trim();  // Trim unnecessary spaces
        int quantity = Integer.parseInt(quantityText);  // Convert String to int
        return quantity;
    }



}


