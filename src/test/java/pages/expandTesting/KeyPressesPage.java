package pages.expandTesting;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class KeyPressesPage {

    public KeyPressesPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="target")
    public WebElement inputBox;

    @FindBy(id="result")
    public WebElement resultText;

}
