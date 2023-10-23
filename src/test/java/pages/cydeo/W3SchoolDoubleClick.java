package pages.cydeo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class W3SchoolDoubleClick {

    public W3SchoolDoubleClick() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="iframeResult")
    public WebElement resultFrame;

    @FindBy(id="demo")
    public WebElement doubleClickMeText;


}
