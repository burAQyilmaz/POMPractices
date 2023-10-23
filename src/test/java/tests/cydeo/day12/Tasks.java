package tests.cydeo.day12;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cydeo.DynamicLoading1;
import pages.cydeo.DynamicLoading7;
import pages.cydeo.LibraryLoginPage;
import utility.BrowserUtility;
import utility.Driver;

import java.time.Duration;

public class Tasks {

    LibraryLoginPage loginPage;
    DynamicLoading7 dynamicLoading7;

    DynamicLoading1 dynamicLoading1;


    @BeforeMethod
    public void setUpMethod() {

        loginPage = new LibraryLoginPage();
        dynamicLoading7 = new DynamicLoading7();
        dynamicLoading1 = new DynamicLoading1();

    }

    @AfterMethod
    public void tearDownMethod() {

        Driver.closeDriver();
    }

    @Test
    public void task1() {

        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Do not enter any information
        //4- Click to “Sign in” button

        loginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.

        String expectedMessage = "This field is required.";
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void task2() {

        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Enter invalid email format

        loginPage.emailBox.sendKeys("vnsjfn" + Keys.ENTER);
        BrowserUtility.sleep(2);

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.

        String expectedMessage = "Please enter a valid email address.";
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        //NOTE: FOLLOW POM DESIGN PATTER
    }

    @Test
    public void task3() {

        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Enter incorrect username or incorrect password


        loginPage.emailBox.sendKeys("burakyilmaz@cydeo.com");
        loginPage.passwordBox.sendKeys("12345");
        loginPage.signInButton.click();
        BrowserUtility.sleep(2);

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password

        String expectedMessage = "Sorry, Wrong Email or Password";
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void task4() {

        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicLoading7.afterLoading.isDisplayed());

        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoading7.image.isDisplayed());

        //Note: Follow POM
    }

    @Test
    public void task5() {

        //TC#5 : Dynamically Loaded Page Elements 1
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        //2. Click to start
        dynamicLoading1.startBtn.click();

        //3. Wait until loading bar disappears
        BrowserUtility.waitForInvisibility(dynamicLoading1.loadingBar);

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoading1.userName.isDisplayed());

        //5. Enter username: tomsmith
        dynamicLoading1.userName.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicLoading1.password.sendKeys("incorrectpassword");

        //7. Click to Submit button
        dynamicLoading1.SubmitBtn.click();

        //8. Assert “Your password is invalid!” text is displayed.
        String expectedMessage="Your password is invalid!";
        String actualMessage=dynamicLoading1.alertMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

        //Note: Follow POM Design Pattern
    }
}
