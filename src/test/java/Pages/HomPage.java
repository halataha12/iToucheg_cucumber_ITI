package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

import java.time.Duration;


public class HomPage {

    By loginSignupElement=By.xpath("//a[@href='https://www.itoucheg.com/my-account/']");

    By viewCartElement=By.xpath("//a[@href='https://www.itoucheg.com/cart/' and contains(@class, 'button wc-forward')]");


    public void loginSignup(){
        Hooks.driver.findElement(loginSignupElement).click();
    }
    public void clickOnViewCartBtn() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartElement));
        cart.click();
    }

}
