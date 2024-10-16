package steps;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckDashboard {
    Faker faker=new Faker();
    HomPage homePage=new HomPage();
    UserRegistrationPage userRegistration=new UserRegistrationPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("the user is registered and in Dashboard Page")
    public void the_user_is_registered() {
        Hooks.user_open_chrome_browser();
        homePage.loginSignup();
        userRegistration
                .GetEmailAddress(faker.internet().emailAddress())
                .GetPassword(faker.internet().password(13, 20));
    }

    @When("the user clicks on the orders link")
    public void the_user_clicks_on_the_orders_link() {
       dashboardPage.clickOnOrders();
    }

    @Then("the user should be navigated directly to the orders page")
    public void the_user_should_be_navigated_directly_to_the_orders_page() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.itoucheg.com/my-account/orders/");

    }

    @When("the user clicks on the downloads link")
    public void the_user_clicks_on_the_downloads_link() {
         dashboardPage.clickOnDownLoads();
    }

    @Then("the user should be navigated directly to the downloads page")
    public void the_user_should_be_navigated_directly_to_the_downloads_page() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.itoucheg.com/my-account/downloads/");

    }

    @When("the user clicks on the Addresses link")
    public void the_user_clicks_on_the_addresses_link() {
           dashboardPage.clickOnAddresses();
    }

    @Then("the user should be navigated directly to the Addresses page")
    public void the_user_should_be_navigated_directly_to_the_addresses_page() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.itoucheg.com/my-account/edit-address/");

    }

    @When("the user clicks on the Account details link")
    public void the_user_clicks_on_the_account_details_link() {
          dashboardPage.clickOnAccountDetails();
    }

    @Then("the user should be navigated directly to the Account details page")
    public void the_user_should_be_navigated_directly_to_the_account_details_page() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.itoucheg.com/my-account/edit-account/");

    }

    @When("the user clicks on the My Coupons link")
    public void the_user_clicks_on_the_my_coupons_link() {
             dashboardPage.clickOnMyCoupons();
    }

    @Then("the user should be navigated directly to the My Coupons page")
    public void the_user_should_be_navigated_directly_to_the_my_coupons_page() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.itoucheg.com/my-account/wt-smart-coupon/");


    }

}
