package steps;

import Pages.HomPage;
import Pages.SearchPage;
import Pages.UserRegistrationPage;
import com.github.javafaker.Faker;
import data.LoadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddProductToCart {
    Faker faker = new Faker();
    HomPage homePage=new HomPage();;
    SearchPage searchPage=new SearchPage();;
    UserRegistrationPage userRegistration=new UserRegistrationPage();
    String ValidNameProduct=LoadProperties.userdata.getProperty("SearchForValidNameProduct");

    @Given("the user is on the Home Page")
    public void the_user_is_on_the_home_page() {
        Hooks.user_open_chrome_browser();
    }

    @When("the user is on the Registration page")
    public void the_user_is_on_the_login_page() {
       homePage.loginSignup();
    }

    @When("the user enters valid credentials and click enter")
    public void the_user_enters_valid_credentials(){
        String Email=faker.internet().emailAddress();
        String Password=faker.regexify("[a-zA-Z0-9!@#$%^&*()_+]{12}");
        userRegistration
                .GetEmailAddress(Email)
                .GetPassword(Password);

 }



    @When("the user searches for Valid Product Name in the search bar")
    public void the_user_searches_for_valid_product_name_in_the_search_bar() {
        searchPage.SearchInput(ValidNameProduct);
}



    @When("the user clicks on the Add to Cart")
    public void the_user_clicks_on_the_Add_To_Cart() throws InterruptedException {
     searchPage.addItemToCart();

    }


    @Then("pop up displayed show product successfully added to cart")
    public void pop_up_displayed_show_product_successfully_added_to_cart() {
        Assert.assertTrue(searchPage.checkPupUp(),"Can not Add item to Cart");
    }

    @When("the user searches for valid Product Name in the search bar")
    public void The_user_searches_for_valid_product_name_in_the_search_bar() throws InterruptedException {
        searchPage.SearchInput(ValidNameProduct);
    }


    @And("the user clicks on the add to cart")
    public void the_user_clicks_on_the_add_to_cart() throws InterruptedException {
         searchPage.addItemToCart();
    }


    @Then("Pop Up displayed show product successfully added to cart")
    public void popupDisplayedShowProductSuccessfullyAddedToCart() {
        Assert.assertTrue(searchPage.checkPupUp(),"Can not Add item to Cart");
    }

}
