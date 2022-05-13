package dz6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(name = "USER_LOGIN")
    WebElement userNameInput;
    @FindBy(name = "USER_PASSWORD")
    WebElement passwordInput;
    @FindBy(xpath = "//form[@name='form_auth']//input[@name='Login']")
    private WebElement loginButton;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage login(String login, String password) {
        By authFormLocator = By.xpath("//form[contains(@name,'form_auth')]");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        userNameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MainPage(webDriver);
    }

    public void checkError(String errorText) {
        //assertThat(webDriver.findElement(By.xpath("//font[@class='errortext']")).getText())
        //.isEqualTo(errorText);
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[@class='errortext']")));

    }
}
