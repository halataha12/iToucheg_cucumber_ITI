package Pages;

import org.openqa.selenium.By;
import steps.Hooks;

public class LogOutPage {

    By logOut=By.xpath("//nav[@class='woocommerce-MyAccount-navigation']//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']//a");
    By confirmLogOut=By.xpath("//div[@class='woocommerce-message message-wrapper']//a[contains(@href, 'action=logout')]");
    public void clickOnConfirmLogOut(){
        Hooks.driver.findElement(confirmLogOut).click();
    }
    public void clickOnLogOutBtn(){
        Hooks.driver.findElement(logOut).click();
    }
}
