
package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

import java.time.Duration;


public class UserRegistrationPage {

    By emailAddress=By.xpath("//input[@type='email']");
    By PasswordInput=By.xpath("//input[@id='reg_password']");
    By PasswordMes=By.xpath("//ul[@class='woocommerce-error message-wrapper']");
    public UserRegistrationPage GetEmailAddress(String EmailAddress){
        WebElement emailElement= Hooks.driver.findElement(emailAddress);
        emailElement.sendKeys(EmailAddress);
        return this;
    }
    public void GetPassword(String Password){
        WebElement emailElement= Hooks.driver.findElement(PasswordInput);
        emailElement.sendKeys(Password);
        emailElement.sendKeys(Keys.ENTER);
    }


    public String ErrorMessage(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        WebElement checkErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordMes));
        return checkErrorMessage.getText();
    }
}

