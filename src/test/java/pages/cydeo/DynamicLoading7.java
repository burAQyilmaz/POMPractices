package pages.cydeo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class DynamicLoading7 {

    public DynamicLoading7() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = ("//strong[.='Done!']"))
    public WebElement afterLoading;

    @FindBy (tagName="img")
    public WebElement image;

}
