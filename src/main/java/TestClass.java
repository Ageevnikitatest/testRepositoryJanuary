import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass {


    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/mykyta/IdeaProjects/chromedriver");

        String element = "//div[@data-filter-name='producer']//div[@class='scrollbar__inner']//label[@for]";

        driver.get("https://bt.rozetka.com.ua/drying_machines/c80222/");
        driver.manage().window().fullscreen();

        List<WebElement> list = driver.findElements(By.xpath(element));

        int i = list.size() - 1;
        while (i > 0 || i == 0) {
            System.out.println(list.get(i).getAttribute("for"));
            i--;
        }
        driver.quit();
    }

    @Test
    public void secondTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mykyta/IdeaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ebay.com");

        WebElement element = driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[@href='https://www.ebay.com/b/Electronics/bn_7000259124']"));
        Actions action = new Actions(driver);

        action.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[@href='https://www.ebay.com/b/Electronics/bn_7000259124']")).isDisplayed();

        driver.findElement(By.xpath("//div[@class='hl-cat-nav__sub-cat-col']//a[@href='https://www.ebay.com/b/Cell-Phones-Smart-Watches-Accessories/15032/bn_1865441']")).click();

        Thread.sleep(5);
        driver.switchTo().alert().accept();

        String driver2 = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.valueOf(driver2)); // новое окно
        driver.switchTo().window("www");    // новая вкладка


        for(String tab: driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }

        driver.quit();

    }
}
