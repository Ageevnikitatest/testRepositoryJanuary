package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void isOpened(){
        By isOpened = By.xpath("//div[@class='col-lg-6']/p");
        Assert.assertTrue("Page is not opened", driver.findElement(isOpened).isDisplayed());
    }

    public RegisterPage clickRegister(){
        By registerButton = By.xpath("//div[@class='float-right buttons']/a[@href='/signup']");
        driver.findElement(registerButton).click();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.isOpened();
        return registerPage;
    }

    public LoginPage clickLogin(){
        By loginBtn = By.xpath("//div[@class='float-right buttons']//a[@href='/login']");

        driver.findElement(loginBtn).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isOpened();
        return loginPage;
    }
}
