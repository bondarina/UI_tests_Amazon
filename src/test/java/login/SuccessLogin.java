package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessLogin {
    public WebDriver driver;
    public SuccessLogin(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(id="nav-link-accountList-nav-line-1")
    private WebElement successLogin;


    public String getUserName(){
        return successLogin.getText();
    }
}

