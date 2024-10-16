package steps;

import Pages.DashboardPage;
import Pages.HomPage;
import Pages.UserRegistrationPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserRegistration {
    Faker faker=new Faker();
    HomPage homePage;
    UserRegistrationPage userregistrationPage;
    DashboardPage dashboardPage;


    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        Hooks.user_open_chrome_browser();

    }

    @When("I click on Register or login Button")
    public void i_click_on_register_or_login_button() {
        homePage=new HomPage();
        homePage.loginSignup();
    }


    @When("I entered EmailAddress ,Password and click on Register Button")
    public void i_entered_email_address_password_and_click_on_register_button() throws InterruptedException {
        userregistrationPage=new UserRegistrationPage();
        String Email=faker.internet().emailAddress();
        String Password=faker.regexify("[a-zA-Z0-9!@#$%^&*()_+]{12}");
        userregistrationPage.GetEmailAddress(Email).GetPassword(Password);
    }

    @Then("the user Registered successfully")
    public void the_user_registered_successfully() {
        dashboardPage =new DashboardPage();
        Assert.assertTrue(dashboardPage.CheckDashboardVisibility());

    }
   @When("I entered not accepted email and accepted Password and click on Register Button")
    public void i_entered_not_accepted__email_address_not_valid_Password_and_click_on_register_button() throws InterruptedException {
        userregistrationPage=new UserRegistrationPage();
        String Email=faker.name()+faker.number().digits(5);
        String Password=faker.regexify("[a-zA-Z0-9!@#$%^&*()_+]{12}");
        userregistrationPage.GetEmailAddress(Email);
        userregistrationPage.GetPassword(Password);
    }

    @Then("the user can not Register")
    public void the_user_can_not_register() {
        userregistrationPage=new UserRegistrationPage();
        Assert.assertEquals(userregistrationPage.ErrorMessage(),"Error: Please provide a valid email address.");
        System.out.println(userregistrationPage.ErrorMessage());
    }

}
