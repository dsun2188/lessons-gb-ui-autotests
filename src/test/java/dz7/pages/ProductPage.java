package dz7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Положить товар в корзину")
    public ProductPage putInCart() {
        webDriver.findElement(By.xpath("//div[@class='but-block']//a[@class='but-green add']")).click();
        return new ProductPage(webDriver);
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//div[@class='cart']//a[@class='but-yellow but']")).click();
        return new CartPage(webDriver);
    }

    @Step("Проверка количества товаров в корзине")
    public ProductPage sumProduct() {
        webDriver.findElement(By.xpath("//img[@class='sum plus']")).click();
        return new ProductPage(webDriver);
    }


}
