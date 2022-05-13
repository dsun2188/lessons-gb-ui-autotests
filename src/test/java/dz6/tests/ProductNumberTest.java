package dz6.tests;

import dz5.BaseTest;
import dz6.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductInCartTest extends BaseTest {

    private static final String URL = "https://gauss-online.ru/";

    @ParameterizedTest
    @DisplayName("Корректное отображение в корзине выбранного товара")
    @ValueSource(strings = {"Лампа Gauss LED Filament ST64 E27 6W Gold 550lm 2400К 1/10/40"})
    void ProductInCart (String productName) throws InterruptedException {

        webDriver.get(URL);

        new MainPage(webDriver).chooseProduct()
                .putInCart()
                .goToCart()
                .checkCart();
    }

}

