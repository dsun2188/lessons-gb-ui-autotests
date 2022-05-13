package dz6.tests;

import dz5.BaseTest;
import dz6.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayOrderWithoutDataTest extends BaseTest {
    private static final String URL = "https://gauss-online.ru/";

    @Test
    @DisplayName("Тест на попытку оформить заказ без заполнения обязательных полей")
    void filterPriceTest() {
        webDriver.get(URL);

        new MainPage(webDriver).chooseProduct()
                .putInCart()
                .goToCart()
                .makeOrder()
                .buyOrder()
                .checkOrderWithoutData();

    }

}
