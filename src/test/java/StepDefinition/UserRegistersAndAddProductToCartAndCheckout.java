package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;

import java.io.IOException;

public class UserRegistersAndAddProductToCartAndCheckout extends BaseClass {

    @And("user adds product to cart")
    public void user_adds_product_to_cart() throws IOException {
        pageFactory.getHomePage().addProductToCart();
    }

    @And("user checkout from cart")
    public void user_checkout_from_cart() throws IOException {
        pageFactory.getHomePage().checkoutFromCart();
    }
}
