package dz5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayOrderWithoutDataTest extends BaseTest {
    @Test
    @DisplayName("Тест на попытку оформить заказ без заполнения обязательных полей")
    void filterPriceTest() {
        webDriver.get("https://gauss-online.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.xpath("//span[@class='name']//a[text()='Лампа Gauss LED Filament ST64 E27 6W Gold 550lm 2400К 1/10/40']")).click();
        webDriver.findElement(By.xpath("//div[@class='but-block']//a[@class='but-green add']")).click();
        webDriver.findElement(By.xpath("//div[@class='cart']//a[@class='but-yellow but']")).click();
        webDriver.findElement(By.xpath("//input[@name='BasketOrder']")).click();
        webDriver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[@class='errortext']")));


    }

}
