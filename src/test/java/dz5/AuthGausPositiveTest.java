package dz5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthGausPositiveTest extends BaseTest{

    @Test
    @DisplayName("Позитивный тест - верный логин и пароль")
    void successfulAuthTest() throws InterruptedException {

        webDriver.get("https://gauss-online.ru/");
        webDriver.manage().window().setSize(new Dimension(1300,720));
        webDriver.findElement(By.linkText("Вход")).click();

        By authFormLocator = By.xpath("//form[contains(@name,'form_auth')]");

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);

        authForm.findElement(By.name("USER_LOGIN")).sendKeys("inv");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("123456");
        authForm.findElement(By.xpath("//form[@name='form_auth']//input[@name='Login']")).click();

        webDriver.findElement(By.linkText("Выход")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Вход")));

    }

}
