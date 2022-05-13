package dz6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage putInCart() {
        webDriver.findElement(By.xpath("//div[@class='but-block']//a[@class='but-green add']")).click();
        return new ProductPage(webDriver);
    }

    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//div[@class='cart']//a[@class='but-yellow but']")).click();
        return new CartPage(webDriver);
    }

    public ProductPage sumProduct() {
        webDriver.findElement(By.xpath("//img[@class='sum plus']")).click();
        return new ProductPage(webDriver);
    }


}
