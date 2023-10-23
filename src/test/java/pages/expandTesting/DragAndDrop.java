package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class DragAndDrop {

    public DragAndDrop() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/div[@id='source']/div")
    public List<WebElement> draggableColors;

    @FindBy(id = "target")
    public WebElement grayZone;

    @FindBy(xpath = "//div[@id='target']/div")
    public List<WebElement>dropZoneColors;




}
