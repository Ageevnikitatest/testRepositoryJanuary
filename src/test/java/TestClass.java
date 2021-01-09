import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;

import java.io.File;
import java.util.List;


public class TestClass {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/mykyta/IdeaProjects/chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void turnDown(){
        driver.quit();
    }


    @Test
    public void test() {

        String element = "//div[@data-filter-name='producer']//div[@class='scrollbar__inner']//label[@for]";
        MainPage browser = new MainPage();
        driver.get("https://bt.rozetka.com.ua/drying_machines/c80222/");
        driver.manage().window().fullscreen();

        List<WebElement> list = driver.findElements(By.xpath(element));

        int i = list.size() - 1;
        while (i > 0 || i == 0) {
            System.out.println(list.get(i).getAttribute("for"));
            i--;
        }
    }

    @Test
    public void secondTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mykyta/IdeaProjects/testselenium/src/main/resources/chromedriver");
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

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  // для скриншотов


        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

    }
}
