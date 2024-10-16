package steps;

import Pages.SearchPage;
import data.LoadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Search {
    SearchPage searchPage=new SearchPage();
    String ValidNameProduct= LoadProperties.userdata.getProperty("SearchForValidNameProduct");
    String invalidNameProduct=LoadProperties.userdata.getProperty("SearchForInvalidNameProduct");
    @Given("the user in home Page")
    public void the_user_in_home_page() {
        Hooks.user_open_chrome_browser();
    }

    @When("The user searches for valid Product Name in the search bar")
    public void the_user_searches_for_valid_product_name_in_the_search_bar() throws InterruptedException {
    searchPage.SearchInput(ValidNameProduct);
    }


    @Then("The user should see a list of products")
    public void the_user_should_see_a_list_of_products() {
        Assert.assertTrue("Error in Result Search",searchPage.SearchForValidProduct());
    }

    @When("The user searches for invalid product name in the search bar")
    public void The_user_searches_for_invalid_product_name_in_the_search_bar() throws InterruptedException {
        searchPage.SearchInput(invalidNameProduct);

    }


    @Then("The user should see a message no products found")
    public void the_user_should_see_a_message_no_products_found() {
        Assert.assertTrue("Error in Result Search",searchPage.SearchForInvalidProduct());
        System.out.println("Search Result: "+searchPage.getSearchForInvalidProduct());
    }
}
