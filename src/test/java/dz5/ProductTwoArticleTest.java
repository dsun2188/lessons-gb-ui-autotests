package dz5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTwoArticleTest extends BaseTest {
    @Test
    @DisplayName("Тест отображения в корзине двух товаров двух артиклей")
    void filterPriceTest() {
        webDriver.get("https://gauss-online.ru/gauss/2854/102802006-lampa-gauss-led-filament-st64-e27-6w-gold-550lm-2400k-1-10-40/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));
        webDriver.findElement(By.xpath("//div[@class='but-block']//a[@class='but-green add']")).click();

        webDriver.get("https://gauss-online.ru/gauss/2854/105802006-lampa-gauss-led-filament-g95-e27-6w-amber-550lm-2400k-1-20/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));
        webDriver.findElement(By.xpath("//div[@class='but-block']//a[@class='but-green add']")).click();

        webDriver.findElement(By.xpath("//div[@class='cart']//a[@class='but-yellow but']")).click();

        List<WebElement> productsNumberInCart = webDriver.findElements(By.xpath("//div[@class='spinner nuclear']//input[@class='qty']"));
        assertThat(productsNumberInCart).hasSize(2);
    }
}
