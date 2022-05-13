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

public class AuthGausPositiveTest extends BaseTest {
    String login = "inv";
    String password = "123456";
    private static final String URL = "https://gauss-online.ru/";

    @Test
    @DisplayName("Позитивный тест - верный логин и пароль")
    void successfulAuthTest() throws InterruptedException {

        webDriver.get(URL);

        new MainPage(webDriver).clickLogin()
                .login(login,password)
                .logout()
                .checklogout();
    }

}