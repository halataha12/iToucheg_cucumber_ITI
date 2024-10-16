package Pages;
import org.openqa.selenium.By;
import steps.Hooks;

public class DashboardPage {

    By dashboardElement=By.xpath("//small[contains(text(), 'Dashboard')]");
    By OrderElement=By.xpath("(//a[contains(@href,'orders')])[4]");
    By DownloadElement=By.xpath("(//a[contains(@href, '/my-account/downloads/')])[3]");
    By AddressesElement=By.xpath("(//a[contains(@href,'address')])[4]");
    By AccountDetailsElement=By.xpath("(//a[contains(@href,'edit-account')])[4]");
    By MyCouponsElement=By.xpath("(//a[contains(@href,'wt-smart-coupon')])[3]");


    public Boolean CheckDashboardVisibility(){
        return Hooks.driver.findElement(dashboardElement).isDisplayed();
    }

    public void clickOnOrders(){
        Hooks.driver.findElement(OrderElement).click();
    }
    public void clickOnDownLoads(){
        Hooks.driver.findElement(DownloadElement).click();
    }
    public void clickOnAddresses(){
        Hooks.driver.findElement(AddressesElement).click();
    }

    public void clickOnAccountDetails(){
        Hooks.driver.findElement(AccountDetailsElement).click();
    }
    public void clickOnMyCoupons(){
        Hooks.driver.findElement(MyCouponsElement).click();
    }
}
