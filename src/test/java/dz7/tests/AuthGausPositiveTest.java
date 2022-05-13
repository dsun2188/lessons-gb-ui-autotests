package dz7.tests;

import dz5.BaseTest;
import dz6.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthGausPositiveTest extends BaseTest {
    String login = "inv";
    String password = "123456";
    private static final String URL = "https://gauss-online.ru/";

    @Test
    @DisplayName("Позитивный тест - верный логин и пароль")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет авторизацию пользователя с верным логином и паролем")
    void successfulAuthTest() throws InterruptedException {

        webDriver.get(URL);

        new MainPage(webDriver).clickLogin()
                .login(login,password)
                .logout()
                .checklogout();
    }

}
