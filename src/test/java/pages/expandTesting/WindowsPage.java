package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class WindowsPage {

    public WindowsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Click Here")
    public WebElement clickBtn;


    @FindBy(tagName = "h1")
    public WebElement headerOfNewPage;
}
