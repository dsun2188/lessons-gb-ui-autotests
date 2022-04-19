package org.example.dz3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Product {
    public static void main( String[] args ) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //WebDriver webDriver = WebDriverManager.chromedriver().create();
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //WebDriver webDriver = new ChromeDriver();
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

    }
}
