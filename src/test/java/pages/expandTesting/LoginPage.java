package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//em")
    public WebElement username;

    @FindBy(xpath = "(//em)[2]")
    public WebElement password;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Login']")
    public  WebElement loginBtn;

    @FindBy(xpath = "//b[.='You logged into a secure area!']")
    public WebElement youLoggedIntoSecureArea;

    @FindBy(partialLinkText = "Logout")
    public WebElement logoutLink;

    @FindBy(xpath = "//b[.='You logged out of the secure area!']")
    public WebElement youLoggedOutOfTheSecureArea;


}
