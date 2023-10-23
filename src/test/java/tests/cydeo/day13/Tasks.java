package tests.cydeo.day13;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cydeo.DynamicControls;
import pages.cydeo.W3SchoolDoubleClick;
import utility.BrowserUtility;
import utility.Driver;

public class Tasks {


    @Test
    public void Task1() {

        //TC #1: Double Click Test
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        W3SchoolDoubleClick w3SchoolDoubleClick = new W3SchoolDoubleClick();

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame(w3SchoolDoubleClick.resultFrame);

        //3. Double click on the text “Double-click me to change my text color.”
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(w3SchoolDoubleClick.doubleClickMeText).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        String expectedText = "red";
        String actualText = w3SchoolDoubleClick.doubleClickMeText.getAttribute("style");

        Assert.assertTrue(actualText.contains(expectedText));

        //NOTE: FOLLOW POM
    }

    @Test
    public void Task2() {

        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        DynamicControls dynamicControls = new DynamicControls();

        //3- Click to “Remove” button
        dynamicControls.removeBtn.click();

        //4- Wait until “loading bar disappears”
        BrowserUtility.waitForVisibilityOf(dynamicControls.loadingBar);

        BrowserUtility.waitForInvisibility(dynamicControls.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        BrowserUtility.sleep(2);
        try {
            Assert.assertFalse(dynamicControls.checkBox.isDisplayed());

        } catch (RuntimeException e) {
            Assert.assertFalse(false);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControls.message.isDisplayed());

        //NOTE: FOLLOW POM
    }

    @Test
    public void Task3() {

        //TC #3: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        //3- Click to “Enable” button
        DynamicControls dynamicControls = new DynamicControls();

        dynamicControls.enableBtn.click();

        //4- Wait until “loading bar disappears”
        BrowserUtility.waitForVisibilityOf(dynamicControls.loadingBar);

        BrowserUtility.waitForInvisibility(dynamicControls.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControls.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControls.message.isDisplayed());

        //NOTE: FOLLOW POM
    }

}
