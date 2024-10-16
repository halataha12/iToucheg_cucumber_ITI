package steps;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LogOut {
    Faker faker=new Faker();
    UserRegistrationPage userRegistrationPage;
    LogOutPage logOut;
    SoftAssert softAssert=new SoftAssert();
   HomPage homPage;
    DashboardPage dashboardPage;
    @Given("the user is on the home Page")
    public void the_user_is_on_the_home_page() {
        homPage =new HomPage();
        Hooks.user_open_chrome_browser();
        homPage.loginSignup();

    }
    @And("The user is Registered")
    public void the_user_logged_in() {
        userRegistrationPage =new UserRegistrationPage();
        String Email=faker.internet().emailAddress();
        String Password=faker.regexify("[a-zA-Z0-9!@#$%^&*()_+]{12}");
        userRegistrationPage.GetEmailAddress(Email).GetPassword(Password);
    }


    @When("The user navigate to Dashboard")
    public void the_user_navigate_to_dashboard() {
    softAssert.assertEquals("https://www.itoucheg.com/my-account/",Hooks.driver.getCurrentUrl());
    }

    @When("clicks on logout")
    public void clicks_on_logout() {
        logOut =new LogOutPage();
        logOut.clickOnLogOutBtn();
    }

    @When("user clicks to confirm Logout")
    public void user_clicks_to_confirm_logout() {
        logOut =new LogOutPage();
        logOut.clickOnConfirmLogOut();
    }

    @Then("the user Logged out successfully")
    public void the_user_logged_out_successfully() {
         dashboardPage =new DashboardPage();
         homPage.loginSignup();
         System.out.println(dashboardPage.CheckDashboardVisibility());
         Assert.assertFalse(dashboardPage.CheckDashboardVisibility(),"user can not log Out");
    }

}
