package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void isOpened() {
        By loginForm = By.xpath("//div[@class='login-password-container-email']");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue("Login page doesn't open. ", driver.findElement(loginForm).isDisplayed());
    }

    public AccountPage signIn(String email, String pass){
        By emailField = By.xpath("//div[@class='login-password-container-email']//input[@id='user']");
        By passField = By.xpath("//div[@class='sc-dNLxif kcFVLf']//input[@id='password']");
        By loginBtnMainPAge = By.xpath("//div[@class='login-password-container-email']//input[@id='login']");
        By loginBtn = By.xpath("//button[@id='login-submit']");

        driver.findElement(emailField).sendKeys(email);
        driver.findElement(loginBtnMainPAge).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(passField).sendKeys(pass);
        driver.findElement(loginBtn).click();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.isOpened();
        return accountPage;
    }
}
