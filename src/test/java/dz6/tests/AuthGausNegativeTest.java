package dz6.tests;

import dz5.BaseTest;
import dz6.pages.LoginPage;
import dz6.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthGausNegativeTest extends BaseTest {
    String login = "inv";
    String password = "invalid_password";
    private static final String URL = "https://gauss-online.ru/";

    @Test
    @DisplayName("Негативный тест - некорректный логин или пароль")
    void failedAuthTest() throws InterruptedException {

        webDriver.get(URL);

        new MainPage(webDriver).clickLogin()
                .login(login,password);
        new LoginPage(webDriver)
                .checkError("//font[@class='errortext']");
    }
}
