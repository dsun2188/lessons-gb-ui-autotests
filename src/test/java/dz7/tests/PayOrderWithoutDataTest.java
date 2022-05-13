package dz7.tests;

import dz5.BaseTest;
import dz6.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PayOrderWithoutDataTest extends BaseTest {
    private static final String URL = "https://gauss-online.ru/";

    @Test
    @DisplayName("Тест на попытку оформить заказ без заполнения обязательных полей")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест на проверку оформления заказа без ввода данных покупателя")
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
