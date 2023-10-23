package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class AddAndRemove {

    public AddAndRemove() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Add Element']")
    public WebElement addButton;

    @FindBy(xpath = "//button[.='Delete']")
    public List<WebElement> deleteButtons;




}
