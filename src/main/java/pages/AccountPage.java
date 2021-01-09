package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void isOpened() {
        By boardBtn = By.xpath("//div[@class='_1ZG6N6wwI3fkaY']//span[text()='Boards']");
        Assert.assertTrue("Account page does not open", driver.findElement(boardBtn).isDisplayed());
    }
}
