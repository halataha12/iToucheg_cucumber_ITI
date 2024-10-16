package steps;

import Pages.HomPage;
import Pages.LoginPage;
import data.LoadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;



public class Login  {
    HomPage homePage;
    LoginPage loginPage;
    String email = LoadProperties.userdata.getProperty("email");
    String password = LoadProperties.userdata.getProperty("Password");
    String invalidPassword=LoadProperties.userdata.getProperty("invalidPassword");
    String invalidEmail= LoadProperties.userdata.getProperty("invalidEmail");


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Hooks.user_open_chrome_browser();
    }

    @When("User click on Register or login Button")
    public void user_click_on_register_or_login_button() {
        homePage=new HomPage();
        homePage.loginSignup();
    }

    @When("the user enters an valid username")
    public void the_user_enters_an_valid_username() {
        loginPage=new LoginPage();
        loginPage.putUsername(email);

    }

    @And("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        loginPage=new LoginPage();
        loginPage.putPassword(password);
    }

    @And("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage=new LoginPage();
        loginPage.clickBtn();

    }
    @Then("the user should be redirected to Home Page")
    public void the_user_should_be_redirected_to_home_page() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.itoucheg.com/","The user must be redirected to the home page ,but this did not happen");
    }

    @When("the user enters an invalid username")
    public void the_user_enters_an_invalid_username() {
        loginPage=new LoginPage();
        loginPage.putUsername(invalidEmail);
    }

    @And("the user enters a invalid password")
    public void the_user_enters_a_invalid_password() {
        loginPage=new LoginPage();
        loginPage.putPassword(invalidPassword);
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_Login_button() {
        loginPage=new LoginPage();
        loginPage.clickBtn();
    }
    @When("user clicks on login and signup Button")
    public void user_clicks_on_login_and_signup_Button() {
        homePage=new HomPage();
        homePage.loginSignup();
    }

    @Then("The user should be redirected to login and signup not dashboard")
    public void the_user_should_be_redirected_to_login_and_signup_not_Dashboard()  {
        loginPage=new LoginPage();
        Assert.assertTrue(loginPage.checkLoginPage(),"User logged in ,This is Dashboard Page");
    }
    @When("user don't enter any data in username and password field and clicks on the Login Button")
    public void user_don_t_enter_any_data_in_username_and_password_field_and_clicks_on_the_login_button() {
        loginPage=new LoginPage();
        loginPage.clickBtn();
    }

    @When("user clicks on login and signup button")
    public void user_clicks_on_login_and_signup_button() {
        homePage=new HomPage();
        homePage.loginSignup();
    }

    @Then("the user should be redirected to login and signup not Dashboard")
    public void the_user_should_be_redirected_to_login_and_signup_not_dashboard(){
        loginPage=new LoginPage();
        Assert.assertTrue(loginPage.checkLoginPage(),"User logged in ,This is Dashboard Page");
    }
}




