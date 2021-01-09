package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {

    private WebDriver driver;
    private By registerField = By.xpath("//div[@id='signup-password']//input[@type='email']");
    private By submitButton = By.xpath("//div[@id='signup-password']//input[@id='signup-submit']");
    private By fullNameField = By.xpath("//input[@class='Input__InputElement-sc-1o6bj35-0 bfCuIo'][@type='email']");
    private By passField = By.xpath("//input[@class='Input__InputElement-sc-1o6bj35-0 bfCuIo'][@type='password']");
    private By submitBtn = By.xpath("//button[@type='submit']");
    private By googleButton = By.xpath("");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void isOpened() {
        Assert.assertTrue("Register window doesn't open", driver.findElement(registerField).isDisplayed());
    }
}
