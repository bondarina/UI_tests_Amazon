package login;

import helpers.TestValues;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import readProperties.ConfProperties;
import java.util.concurrent.TimeUnit;


public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static SuccessLogin successLogin;


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        successLogin = new SuccessLogin(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.ClickStartSignInButton();
      loginPage.inputLogin(ConfProperties.getProperty("login"));
      Thread.sleep(2000);
      loginPage.clickContinueButton();
      loginPage.inputPassword(ConfProperties.getProperty("password"));
      Thread.sleep(2000);
      loginPage.clickSignInButton();
        Thread.sleep(10000);

      Assertions.assertEquals(successLogin.getUserName(), TestValues.USER_NAME);

    }

    @AfterEach
    public void tearDown(){
        driver.close();
        driver.quit();
    }


}