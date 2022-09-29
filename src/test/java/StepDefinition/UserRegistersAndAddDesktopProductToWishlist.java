package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import java.io.IOException;

public class UserRegistersAndAddDesktopProductToWishlist extends BaseClass {
    @And("user navigates to the desktop page")
    public void user_navigates_to_the_desktop_page() throws IOException {
        pageFactory.getHomePage().navigateToDesktopPage();
    }

    @And("user adds a desktop product to wishlist")
    public void user_adds_a_desktop_product_to_wishlist() throws IOException {
        pageFactory.getHomePage().addDesktopToWishlist();
    }
}