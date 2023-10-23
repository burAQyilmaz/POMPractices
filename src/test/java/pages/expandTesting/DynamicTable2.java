package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class DynamicTable2 {

    public DynamicTable2() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//td[.='Chrome']/..//td[contains(text(),'%')]")
    public WebElement valueOfCPUChromeTable;

    @FindBy(id = "chrome-cpu")
    public WebElement valueOfCPUYellowLabel;



}
