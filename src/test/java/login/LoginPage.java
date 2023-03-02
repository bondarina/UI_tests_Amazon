package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfProperties;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy (xpath = "//div[@class='layoutToolbarPadding']")
    private WebElement startSignInButton;

    @FindBy (id = "ap_email")
    private WebElement loginField;

    @FindBy (className = "a-button-input")
    private WebElement continueButton;

    @FindBy (id = "ap_password")
    private WebElement passwordField;

    @FindBy (className = "a-button-input")
    private WebElement singInButton;

    public void ClickStartSignInButton () {
        startSignInButton.click();
    }

    public void inputLogin (String login) {
        loginField.sendKeys(ConfProperties.getProperty("login"));
    }

    public void inputPassword (String password) {
        passwordField.sendKeys(ConfProperties.getProperty("password"));
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickSignInButton(){
        singInButton.click();
    }

}