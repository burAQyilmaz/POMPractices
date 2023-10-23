package tests.cydeo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cydeo.DashBoard;
import pages.cydeo.LibraryLoginPage;
import utility.BrowserUtility;
import utility.Driver;

public class Login {

    @Test
    public void login(){

        //Goto https://library1.cydeo.com/login.html page
        Driver.getDriver().get("https://library1.cydeo.com/login.html");
        LibraryLoginPage libraryLoginPage=new LibraryLoginPage();
        DashBoard dashBoard=new DashBoard();

        //Login with this values  librarian8@library and libraryUser
        libraryLoginPage.emailBox.sendKeys("librarian8@library");
        libraryLoginPage.passwordBox.sendKeys("libraryUser");
        libraryLoginPage.signInButton.click();

        //Verify the count of users is 230
        BrowserUtility.sleep(2);
        Assert.assertEquals(dashBoard.countOfUser.getText(),"230");
    }
}
