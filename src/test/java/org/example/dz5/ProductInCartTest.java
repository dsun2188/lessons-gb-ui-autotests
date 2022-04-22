package org.example.dz5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductInCartTest extends BaseTest{

    @ParameterizedTest
    @DisplayName("Корректное отображение в корзине выбранного товара")
    @ValueSource(strings = {"Лампа Gauss LED Filament ST64 E27 6W Gold 550lm 2400К 1/10/40"})
    void ProductInCart (String productName) throws InterruptedException {

        webDriver.get("https://gauss-online.ru/");
        webDriver.manage().window().setSize(new Dimension(1300,720));

        webDriver.findElement(By.xpath("//span[@class='name']//a[text()='Лампа Gauss LED Filament ST64 E27 6W Gold 550lm 2400К 1/10/40']")).click();
        webDriver.findElement(By.xpath("//div[@class='but-block']//a[@class='but-green add']")).click();
        webDriver.findElement(By.xpath("//div[@class='cart']//a[@class='but-yellow but']")).click();

        //System.out.println("Actual cart size = " + webDriver.findElements(By.xpath("//div[@class='spinner nuclear']//input[@class='qty']")).size());
        //System.out.println("Expected cart size = 1");

        List<WebElement> productsInCart = webDriver.findElements(By.xpath("//div[@class='spinner nuclear']//input[@class='qty']"));
        assertThat(productsInCart).hasSize(1);

        assertThat(productsInCart.get(0).findElement(By.xpath(".//td[@class='td-2']//a[text()='Лампа Gauss LED Filament ST64 E27 6W Gold 550lm 2400К 1/10/40']")).getText())
                .as("Название товара в корзине: " + productName)
                .isEqualTo(productName);
    }

}


        /*ChromeOptions chromeOptions = new ChromeOptions();
            WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.get("https://gauss-online.ru/");
            webDriver.manage().window().setSize(new Dimension(1300,720));
            webDriver.findElement(By.xpath("//span[@class='name']//a[text()='Лампа Gauss LED Filament ST64 E27 6W Gold 550lm 2400К 1/10/40']")).click();
            Thread.sleep(2000);
            webDriver.findElement(By.xpath("//div[@class='but-block']//a[@class='but-green add']")).click();
            Thread.sleep(2000);
            webDriver.findElement(By.xpath("//div[@class='cart']//a[@class='but-yellow but']")).click();
            Thread.sleep(2000);
            System.out.println("Actual cart size = " + webDriver.findElements(By.xpath("//div[@class='spinner nuclear']//input[@class='qty']")).size());
            System.out.println("Expected cart size = 1");
            webDriver.quit();
        }*/