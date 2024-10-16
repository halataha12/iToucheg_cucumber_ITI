package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import steps.Hooks;

public class ProductDetailsPage {

    By proceedToCheckoutElement=By.xpath("//main//div[contains(@class, 'wc-proceed-to-checkout')]//a[contains(@class, 'checkout-button')] ");
    By ProductImg=By.xpath("//img[contains(@class, 'wp-post-image ux-skip-lazy')]");
    By PriceProduct1=By.xpath("//bdi[contains(text(), '290')]");
    By PriceProduct2=By.xpath("//bdi[contains(text(), '2,999')]");
    By Instock=By.xpath("//p[contains(text(), 'In stock')]");
    By OutStock=By.xpath("//p[contains(text(),'Out of stock')]");
    By AddToCart=By.xpath("//button[contains(text(), 'Add to cart')]");
    By PupUp=By.xpath("//div[contains(@id,'cart-popup')]");
    By username=By.xpath("//input[contains(@class,'cwgstock_name')]");
    By useremail=By.xpath("//input[contains(@class,'cwgstock_email')]");
    By usernumber=By.xpath("//input[contains(@class,'cwgstock_phone')]");
    By sendEmailInput=By.xpath("//input[contains(@class,'cwgstock_button ')]");
    By successfulMessage=By.xpath("//div[contains(text(),'You have successfully subscribed')]");
     public void clickOnProceedToCheckout() throws InterruptedException {
        Hooks.driver.findElement(proceedToCheckoutElement).click();

    }
    public boolean checkProduct() {
       return Hooks.driver.findElement(ProductImg).isDisplayed();
    }
    public String checkPrice(){
        JavascriptExecutor js=(JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,300)");
        return Hooks.driver.findElement(PriceProduct1).getText();
    }
    public String checkPriceOfProduct2(){
        JavascriptExecutor js=(JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,300)");
        return Hooks.driver.findElement(PriceProduct2).getText();
    }
    public boolean checkStock(){
        return Hooks.driver.findElement(Instock).isDisplayed();
    }
    public boolean checkOutOfStock(){
        return Hooks.driver.findElement(OutStock).isDisplayed();
    }
    public  boolean PupUp(){
        Hooks.driver.findElement(AddToCart).click();
        return Hooks.driver.findElement(PupUp).isDisplayed();
    }
    public ProductDetailsPage fillname(String name){
        Hooks.driver.findElement(username).sendKeys(name);
        return this;
    }
    public ProductDetailsPage fillemail(String email){
        Hooks.driver.findElement(useremail).sendKeys(email);
        return this;
    }
    public ProductDetailsPage fillPhoneNumber(String number){
        Hooks.driver.findElement(usernumber).sendKeys(number);
        return this;
    }
    public ProductDetailsPage clickInSendEmail(){
        Hooks.driver.findElement(sendEmailInput).click();
        return this;
    }
    public String getMessage(){
        return Hooks.driver.findElement(successfulMessage).getText();
    }
}
