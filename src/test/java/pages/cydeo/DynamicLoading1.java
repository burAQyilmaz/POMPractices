package pages.cydeo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class DynamicLoading1 {

    public DynamicLoading1() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//button[.='Start']")
    public WebElement startBtn;

    @FindBy(id="loading")
    public WebElement loadingBar;

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="pwd")
    public WebElement password;

    @FindBy(xpath="//button[.='Submit']")
    public WebElement SubmitBtn;

    @FindBy(id="flash")
    public WebElement alertMessage;




}
