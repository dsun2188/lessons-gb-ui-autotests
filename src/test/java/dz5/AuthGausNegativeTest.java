package dz5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthGausNegativeTest extends BaseTest{

    @Test
    @DisplayName("Негативный тест - некорректный логин или пароль")
    void failedAuthTest() throws InterruptedException {

        webDriver.get("https://gauss-online.ru/");
        webDriver.manage().window().setSize(new Dimension(1300,720));
        webDriver.findElement(By.linkText("Вход")).click();

        By authFormLocator = By.xpath("//form[contains(@name,'form_auth')]");

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);

        authForm.findElement(By.name("USER_LOGIN")).sendKeys("inv");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("invalid_password");
        authForm.findElement(By.xpath("//form[@name='form_auth']//input[@name='Login']")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[@class='errortext']")));
    }
}
