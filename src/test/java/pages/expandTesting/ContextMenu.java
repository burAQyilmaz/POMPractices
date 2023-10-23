package pages.expandTesting;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class ContextMenu {

    public ContextMenu() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "hot-spot")
    public WebElement frameArea;


}
