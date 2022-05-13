package dz6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage{

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage checkCart() {
        List<WebElement> productsInCart = webDriver.findElements(By.xpath("//div[@class='spinner nuclear']//input[@class='qty']"));
        assertThat(productsInCart).hasSize(1);
        return this;
    }

    public CartPage checkSumCart() {
        List<WebElement> productsInCart = webDriver.findElements(By.xpath("//div[@class='spinner nuclear']//input[@class='qty']"));
        assertThat(productsInCart).hasSize(1);
        return this;
    }

    public CartPage checkSum2articleCart() {
        List<WebElement> productsInCart = webDriver.findElements(By.xpath("//div[@class='spinner nuclear']//input[@class='qty']"));
        assertThat(productsInCart).hasSize(2);
        return this;
    }

    public CartPage makeOrder() {
        webDriver.findElement(By.xpath("//input[@name='BasketOrder']")).click();
        return this;
    }

    public CartPage buyOrder() {
        webDriver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        return this;
    }

    public CartPage checkOrderWithoutData() {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[@class='errortext']")));
        return this;
    }


}
