package dz6.tests;

import dz5.BaseTest;
import dz6.pages.CartPage;
import dz6.pages.MainPage;
import dz6.pages.ProductPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTwoArticleTest extends BaseTest {

    private static final String URL1 = "https://gauss-online.ru/gauss/2854/102802006-lampa-gauss-led-filament-st64-e27-6w-gold-550lm-2400k-1-10-40/";
    private static final String URL2 = "https://gauss-online.ru/gauss/2854/105802006-lampa-gauss-led-filament-g95-e27-6w-amber-550lm-2400k-1-20/";
    @Test
    @DisplayName("Тест отображения в корзине двух товаров двух артиклей")
    void filterPriceTest() {
        webDriver.get(URL1);
        new ProductPage(webDriver).putInCart();

        webDriver.get(URL2);
        new ProductPage(webDriver).putInCart()
                .goToCart()
                .checkSum2articleCart();
    }

}
