package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.nio.file.WatchEvent;
import java.util.List;

public class RadioButtons {

    public RadioButtons() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> radioButtons;

}
