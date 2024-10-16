package Pages;

import org.openqa.selenium.By;
import steps.Hooks;

public class LoginPage {
    By UsernameElement=By.xpath("//input[@type='text']");
    By passwordElement=By.xpath("//input[@type='password']");
    By btnElement=By.xpath("//button[@type='submit']");
    By LoginPage=By.xpath("//div[@class='account-login-inner']");

    public LoginPage putUsername(String email){
        Hooks.driver.findElement(UsernameElement).sendKeys(email);
        return this;
    }
    public LoginPage putPassword(String password){
        Hooks.driver.findElement(passwordElement).sendKeys(password);
        return this;

    }
    public void clickBtn(){
        Hooks.driver.findElement(btnElement).click();
    }

    public boolean checkLoginPage(){
       return Hooks.driver.findElement(LoginPage).isDisplayed();
    }
}
