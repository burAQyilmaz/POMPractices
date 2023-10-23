package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class DynamicTable {

    public DynamicTable() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='First Name']")
    public WebElement headerFirstName;

    @FindBy(xpath = "(//span[.='Last Name'])[2]")
    public WebElement headerLastName;

    @FindBy(xpath = "//table[@id='table1']//td[2]")
    public List<WebElement> firstNamesT1;

    @FindBy(xpath = "//table[@id='table2']//td[1]")
    public List<WebElement> lastNamesT2;



}
