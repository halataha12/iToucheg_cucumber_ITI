package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

import java.time.Duration;

public class CheckOutPage {
    By firstnameInput=By.xpath("//input[@name='billing_first_name']"); //billing_first_name
    By lastnameInput=By.xpath("//input[@name='billing_last_name']");
    By phoneInput=By.xpath("//input[@name='billing_phone']");
    By emailInput=By.xpath("//input[@name='billing_email']");
    By streetNumberInput=By.xpath("//input[@name='billing_address_1']");
    By moreInformationInput=By.xpath("//input[@name='billing_address_2']");
    By cityInput=By.xpath("//input[@name='billing_city']");
    By PostcodeInput=By.xpath("//input[@name='billing_postcode']");
    By clickOnDiv=By.xpath("//div[contains(@class, 'large-7') and contains(@class, 'col')]"); //*[@id="customer_details"]/div[1]/div/div
    By StateElement=By.xpath("//select[@name='billing_state']");
    By error=By.xpath("//div[contains(@class, 'woocommerce-NoticeGroup-checkout')]/ancestor::div");
    By  selectcoupon=By.xpath("//a[contains(@class, 'showcoupon') and contains(@href, '#')]");
    By couponInput=By.xpath("//input[contains(@id, 'coupon_code') and contains(@class, 'input-text')]");
    By couponBtn=By.xpath("//button[@name='apply_coupon']");
    By MessageInvalidCoupon=By.xpath("//ul[contains(@class, 'woocommerce-error') and contains(@class, 'message-wrapper')]\n");
    By PlaceOrder=By.id("place_order");
    public void clickOnDiv(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnDiv));
        element.click();
    }
    public CheckOutPage putFirstName(String Firstname) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameInput));
        firstname.sendKeys(Firstname);
        return this;

    }


    public CheckOutPage putLastName(String Lastname){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(lastnameInput));
        lastname.sendKeys(Lastname);
        return this;

    }
    public CheckOutPage putPhoneNum(String phoneNumber){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        WebElement phoneNum = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        phoneNum.sendKeys(phoneNumber);
        return this;


    }
    public CheckOutPage putEmail(String email) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement Email= Hooks.driver.findElement(emailInput);
        Email.sendKeys(email);
        return this;
    }
    public CheckOutPage PutStreetNumber(String StreetNumber) {

        WebElement StreetNum= Hooks.driver.findElement(streetNumberInput);
        StreetNum.sendKeys(StreetNumber);
        return this;
    }
    public CheckOutPage putMoreInformation(String moreInformation){
        WebElement moreInfo= Hooks.driver.findElement(moreInformationInput);
        moreInfo.sendKeys(moreInformation);
        return this;
    }
    public CheckOutPage putCity(String City){
        WebElement city= Hooks.driver.findElement(cityInput);
        city.sendKeys(City);
        return this;
    }
    public CheckOutPage putPostcode(String postcode){
        WebElement Postcode= Hooks.driver.findElement(PostcodeInput);
        Postcode.sendKeys(postcode);
        return this;
    }

    public CheckOutPage selectState() throws InterruptedException {
        WebElement selectStateElement = Hooks.driver.findElement(StateElement);
        Select state = new Select(selectStateElement);
        state.selectByVisibleText("Aswan");
        Thread.sleep(3000);
        return this;
    }
    public void clickOnPalaceOrder() {
        WebElement placeOrderButton = Hooks.driver.findElement(PlaceOrder);
        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", placeOrderButton);



    }
    public boolean ErrorMessage() throws InterruptedException {
        Thread.sleep(3000);
        return Hooks.driver.findElement(error).isDisplayed();
    }
    public void checkCoupon() {
        Hooks.driver.findElement(selectcoupon).click();
    }
    public void putCoupon(String coupon){
        Hooks.driver.findElement(couponInput).sendKeys(coupon);
        Hooks.driver.findElement(couponBtn).click();
    }
    public boolean Messagecoupon(){
        return Hooks.driver.findElement(MessageInvalidCoupon).isDisplayed();
    }
}
