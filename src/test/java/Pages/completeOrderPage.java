package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

import java.time.Duration;

public class completeOrderPage {


    By completeOrderText=By.xpath("//p[@class='success-color woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']/strong");


public String checkCompleteOrderPage(){
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
    WebElement orderCompleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(completeOrderText));

    return orderCompleteElement.getText();

}



}
