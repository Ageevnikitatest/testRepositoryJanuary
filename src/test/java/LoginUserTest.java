import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class LoginUserTest {

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
    public void loginUserTest(){
        String email = "fillipprillip@gmail.com";
        String pass = "W21012021!";

        driver.get("http://trello.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.isOpened();

        LoginPage loginPage = mainPage.clickLogin();
        loginPage.signIn(email, pass);
    }
}
