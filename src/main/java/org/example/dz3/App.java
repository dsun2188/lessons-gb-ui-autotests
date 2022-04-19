package org.example.dz3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App
{
    public static void main( String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //WebDriver webDriver = WebDriverManager.chromedriver().create();
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://gauss-online.ru/");
        webDriver.manage().window().setSize(new Dimension(1300,720));
        Thread.sleep(3000);
        webDriver.findElement(By.linkText("Вход")).click();
        Thread.sleep(3000);

        /*WebElement authForm = webDriver.findElement(By.xpath("form[@name='form_auth']"));
        authForm.findElement(By.name("USER_LOGIN")).sendKeys("inv");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("123456");
        authForm.findElement(By.xpath("//input[@name='Login']")).click();*/

        By authFormLocator = By.xpath("//form[contains(@name,'form_auth')]");

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);

        authForm.findElement(By.name("USER_LOGIN")).sendKeys("inv");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("123456");
        authForm.findElement(By.xpath("//form[@name='form_auth']//input[@name='Login']")).click();

        webDriver.findElement(By.linkText("Выход")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Вход")));

        Thread.sleep(2000);
        webDriver.quit();

    }
}
