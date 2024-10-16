package steps;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import com.github.javafaker.Faker;
import data.LoadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
public class ProductDetails {
    Faker faker=new Faker();
    SearchPage searchPage=new SearchPage();
    String ProductName= LoadProperties.userdata.getProperty("ProductName");
    ProductDetailsPage productDetailsPage =new ProductDetailsPage();
    String Firstname = LoadProperties.userdata.getProperty("Firstname");
    String PhoneNumber= LoadProperties.userdata.getProperty("PhoneNumber");

    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        Hooks.user_open_chrome_browser();

    }

    @When("the user enters product in the search bar and clicks on search button")
    public void the_user_enters_product_in_the_search_bar() throws InterruptedException {
        searchPage.SearchInput(ProductName);
    }


    @Then("the search results page for products is displayed")
    public void the_search_results_page_for_products_is_displayed() {
        Assert.assertTrue(searchPage.SearchForValidProduct());
    }

    @When("the user clicks on the product which add to cart is visible")
    public void the_user_clicks_on_the_product_which_add_to_cart_is_visible() {
          searchPage.clickOnProductWhichAddToCartVisible();
    }


    @Then("the product details page is displayed")
    public void the_product_details_page_is_displayed() {
        Assert.assertTrue(productDetailsPage.checkProduct());
    }

    @Then("the user check the price of the product")
    public void the_user_check_the_price_of_the_product() {
       Assert.assertEquals(productDetailsPage.checkPrice(),"290 EGP","Prices are not Equal");

    }

    @Then("the product is available with the status In Stock")
    public void the_product_is_available_with_the_status_in_stock() {
        Assert.assertTrue(productDetailsPage.checkStock());

    }

    @Then("the user can Add Product To cart")
    public void the_user_can_click_on_Add_to_cart() {

       Assert.assertTrue(productDetailsPage.PupUp());

    }

    @When("the user clicks on the product which add to cart is invisible")
    public void the_user_clicks_on_the_product_which_add_to_cart_is_invisible() {
      searchPage.clickOnProductWhichAddToCartInvisible();
    }
    @Then("The product details page is displayed")
    public void The_product_details_page_is_displayed() {
        Assert.assertTrue(productDetailsPage.checkProduct());
    }
    @Then("the user check the price of the Product")
    public void the_user_check_the_price_of_The_product() {
        Assert.assertEquals(productDetailsPage.checkPriceOfProduct2(),"2,999 EGP","Prices are not Equal");

    }
    @Then("the product status is Out of Stock")
    public void the_product_status_is_Out_Of_Stock() {
        Assert.assertTrue(productDetailsPage.checkOutOfStock());
    }

    @Then("the user is prompted to Notify when stock available with the option to provide an email and phone number.")
    public void the_user_is_prompted_to_with_the_option_to_provide_an_email_and_phone_number() {
    productDetailsPage.fillname(Firstname).fillemail(faker.internet().emailAddress()).fillPhoneNumber(PhoneNumber).clickInSendEmail();
    Assert.assertEquals(productDetailsPage.getMessage(),"You have successfully subscribed, we will inform you when this product back in stock");
    }

}
