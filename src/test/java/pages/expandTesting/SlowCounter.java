package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class SlowCounter {
    public SlowCounter() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="#result p")
    public WebElement message;
}
