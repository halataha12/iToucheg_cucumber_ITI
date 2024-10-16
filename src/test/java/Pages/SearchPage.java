package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    By SearchElement=By.xpath("//div[@class='header-search-form-wrapper']//input[@type='search']");

    By AddItemElement =By.xpath("//a[@href='?add-to-cart=40211' and contains(@class, 'primary is-small mb-0 button product_type_simple add_to_cart_button ajax_add_to_cart is-gloss')]");
    By pupUpElement=By.xpath("//span[@class='heading-font uppercase']");

    By searchResult=By.xpath("//div[@class='products row row-small large-columns-4 medium-columns-3 small-columns-2 has-shadow row-box-shadow-2 row-box-shadow-2-hover has-equal-box-heights equalize-box']");

    By notFoundSearchResult=By.xpath("//div[contains(text(),'No products were found matching your selection.')]");
    By Products=By.cssSelector(".product");
    By ReadMoreElement=By.xpath("//a[contains(text(),'Read more')]");
    public SearchPage SearchInput(String Product) {
        WebElement searchBox = Hooks.driver.findElement(SearchElement);
        searchBox.sendKeys(Product);
        searchBox.sendKeys(Keys.ENTER);
        return this;
    }


    public SearchPage addItemToCart() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,600)");
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        WebElement AddToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(AddItemElement));
        AddToCart.click();
        Thread.sleep(8000);
        return this;
    }
    public boolean checkPupUp(){
         WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
         WebElement pupUp = wait.until(ExpectedConditions.visibilityOfElementLocated(pupUpElement));
         return pupUp.isDisplayed();
    }

    public boolean SearchForValidProduct(){
        WebElement search=Hooks.driver.findElement(searchResult);
        return search.isDisplayed();
    }

    public boolean SearchForInvalidProduct(){
        WebElement invalidSearch=Hooks.driver.findElement(notFoundSearchResult);
        return invalidSearch.isDisplayed();
    }
    public String getSearchForInvalidProduct(){
        WebElement invalidSearch=Hooks.driver.findElement(notFoundSearchResult);
        return invalidSearch.getText();
    }
    public void clickOnProductWhichAddToCartVisible(){
        List<WebElement> products = Hooks.driver.findElements(Products);
        if (products.size() > 0) {
            WebElement firstProduct = products.get(0);
            firstProduct.click();
        } else {
            System.out.println("No products found.");
        }
    }
    public void clickOnProductWhichAddToCartInvisible(){
        Hooks.driver.findElement(ReadMoreElement).click();

    }
}
