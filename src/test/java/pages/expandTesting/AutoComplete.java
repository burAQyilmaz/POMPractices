package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class AutoComplete {

    public AutoComplete() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "country")
    public WebElement inputCountry;

    @FindBy(css= "#countryautocomplete-list div")
    public List<WebElement> listOfCountriesStartedWithA;

    @FindBy(className = "mx-2")
    public WebElement submitBtn;

    @FindBy(id = "result")
    public WebElement resultText;




}
