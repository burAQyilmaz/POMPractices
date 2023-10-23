package pages.cydeo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class DynamicControls {

    public DynamicControls() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath="//button[.='Remove']")
    public WebElement removeBtn;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(id = "checkbox")
    public WebElement checkBox;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableBtn;

    @FindBy(css="#input-example>input")
    public WebElement inputBox;
}
