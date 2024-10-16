package steps;

import Pages.*;
import com.github.javafaker.Faker;
import data.LoadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class checkOut  {
    Faker faker=new Faker();
    //Use Case Technique
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;
    CheckOutPage checkOutPage;
    HomPage homePage=new HomPage();
    completeOrderPage completeorderPage;
    UserRegistrationPage userRegistration=new UserRegistrationPage();
    String StreetNumber = LoadProperties.userdata.getProperty("StreetNumber");
    String PhoneNumber= LoadProperties.userdata.getProperty("PhoneNumber");
    String ValidNameProduct=LoadProperties.userdata.getProperty("SearchForValidNameProduct");
    String Firstname = LoadProperties.userdata.getProperty("Firstname");
    String Lastname = LoadProperties.userdata.getProperty("Lastname");
    String MoreInformation=LoadProperties.userdata.getProperty("MoreInformation");
    String City=LoadProperties.userdata.getProperty("City");
    String PostCode = LoadProperties.userdata.getProperty("PostCode");

    @Given("the user is Registered")
    public void the_user_is_registered() {
         Hooks.user_open_chrome_browser();
         homePage.loginSignup();
         userRegistration
                 .GetEmailAddress(faker.internet().emailAddress())
                 .GetPassword(faker.internet().password(13, 20));
    }
    @When ("The user search for item and Add item to cart")
    public void The_user_search_for_Add_item_to_cart() throws InterruptedException {

     searchPage =new SearchPage();

     searchPage
             .SearchInput(ValidNameProduct)
             .addItemToCart();


    }
   @When("pop up displayed show Cart items and the user click on view Cart button")
   public void pop_up_displayed_show_cart_items_and_the_user_click_on_view_cart_button() throws InterruptedException {
       Thread.sleep(8000);
       homePage=new HomPage();
       homePage.clickOnViewCartBtn();
   }



    @And("The user click proceed to cart")
    public void the_user_click_on_checkout_button() throws InterruptedException {
      productDetailsPage =new ProductDetailsPage();
      productDetailsPage.clickOnProceedToCheckout();
    }

    @Then("the user navigates to check out page")
    public void the_user_navigates_to_check_out_page() {
        Assert.assertEquals("Error","https://www.itoucheg.com/checkout/", Hooks.driver.getCurrentUrl());

    }


    @When("the users enter their billing and shipping information")
    public void the_users_enter_their_billing_and_shipping_information() throws InterruptedException {
        checkOutPage =new CheckOutPage();
        checkOutPage.clickOnDiv();
        checkOutPage.putFirstName(Firstname)
            .putLastName(Lastname)
            .putPhoneNum(PhoneNumber)
            .PutStreetNumber(StreetNumber)
            .putMoreInformation(MoreInformation)
            .putCity(City)
            .putPostcode(PostCode)
            .selectState();
    }

    @When("clicks Place order")
    public void clicks_pace_order() throws InterruptedException {
        checkOutPage = new CheckOutPage();
         checkOutPage.clickOnPalaceOrder();

    }

    @Then("the order should be placed successfully and go to Order complete Page")
    public void the_order_should_be_placed_successfully_and_go_to_order_complete_page() {
        completeorderPage =new completeOrderPage();
        Assert.assertEquals("Thank you. Your order has been received.",completeorderPage.checkCompleteOrderPage());
    }

    @When("the user does not fall in the required billing details and clicks pace order")
    public void the_user_does_not_fall_in_the_requred_billing_details() throws InterruptedException {
        checkOutPage = new CheckOutPage();
        checkOutPage.clickOnPalaceOrder();
    }

    @Then("the user should see an error message indicating the missing fields")
    public void the_user_should_see_an_error_message_indicating_the_missing_fields() throws InterruptedException {
        checkOutPage = new CheckOutPage();
        Assert.assertTrue(checkOutPage.ErrorMessage());
    }

    @When("user click on click here to enter you code")
    public void user_click_on_click_here_to_enter_you_code() {
        checkOutPage = new CheckOutPage();
        checkOutPage.checkCoupon();

    }
    @When("User puts Invalid code and clicks on button")
    public void user_puts_invalid_code() {
        checkOutPage = new CheckOutPage();
        checkOutPage.putCoupon("123454");
    }
    @Then("Message displayed says Coupon does not exist")
    public void message_displayed_says_coupon_does_not_exist() {
        checkOutPage = new CheckOutPage();
        Assert.assertTrue(checkOutPage.Messagecoupon());
    }

}
