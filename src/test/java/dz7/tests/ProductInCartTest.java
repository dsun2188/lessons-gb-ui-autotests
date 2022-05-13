package dz7.tests;

import dz5.BaseTest;
import dz6.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductInCartTest extends BaseTest {

    private static final String URL = "https://gauss-online.ru/";

    @ParameterizedTest
    @DisplayName("Корректное отображение в корзине выбранного товара")
    @ValueSource(strings = {"Лампа Gauss LED Filament ST64 E27 6W Gold 550lm 2400К 1/10/40"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет отображение выбранного товара")
    void ProductInCart (String productName) throws InterruptedException {

        webDriver.get(URL);

        new MainPage(webDriver).chooseProduct()
                .putInCart()
                .goToCart()
                .checkCart();
    }

}

