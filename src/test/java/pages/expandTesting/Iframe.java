package pages.expandTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class Iframe {

    public Iframe() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".ytp-title-link")
    public WebElement titleOfVideo;

    @FindBy(css = "#tinymce p")
    public WebElement commentFields;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "btn-subscribe")
    public WebElement subscribeBtn;

    @FindBy(id = "iframe-youtube")
    public WebElement frameOfVideo;

    @FindBy(id = "mce_0_ifr")
    public WebElement frameOfComment;

    @FindBy(id = "email-subscribe")
    public WebElement frameOfSub;

    @FindBy(id = "success-message")
    public WebElement messageOfSub;

}
