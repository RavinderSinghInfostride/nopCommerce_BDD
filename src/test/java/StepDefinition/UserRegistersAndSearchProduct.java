package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class UserRegistersAndSearchProduct extends BaseClass {
    @Given("user is on the home page of the website")
    public void user_is_on_the_home_page_of_the_website() throws IOException {
        setup();
    }

    @When("user user navigates to the register page")
    public void user_user_navigates_to_the_register_page() {
        pageFactory.getHomePage().userNavigatesToRegisterPage();
    }

    @Then("user fill all the required details and clicks the register button")
    public void user_fill_all_the_required_details_and_clicks_the_register_button() throws IOException {
        pageFactory.getHomePage().userRegisters();
    }

    @And("user clicks the continue button")
    public void user_clicks_the_continue_button() {
        pageFactory.getHomePage().continueButtonClick();
    }

    @And("user provides the product input in the search box and clicks search button")
    public void user_provides_the_product_input_in_the_search_box_and_clicks_search_button() throws IOException {
        pageFactory.getHomePage().searchProduct();
    }

    @And("the product searched is displayed")
    public void the_product_searched_is_displayed() throws IOException {
        pageFactory.getHomePage().productSearchedIsDisplayedVerify();
    }

    @And("user logout and browser closes")
    public void user_logout_and_browser_closes() {
        logoutUser();
        close_browser();
    }
}