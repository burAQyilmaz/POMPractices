package tests.expandTesting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.expandTesting.*;
import utility.BrowserUtility;
import utility.ConfigReader;
import utility.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasks {

    @AfterMethod

    public void tearDownMethod() {

        Driver.closeDriver();
    }

    @Test
    public void task1() {

        AddAndRemove addAndRemoveElements = new AddAndRemove();

        //Goto https://practice.expandtesting.com/add-remove-elements page
        Driver.getDriver().get("https://practice.expandtesting.com/add-remove-elements");

        //Click "Add Element" button 20 times
        for (int i = 0; i < 20; i++) {

            addAndRemoveElements.addButton.click();
        }

        //Verify if 20 "Delete" button element occurs
        //Click each "Delete" button

        int actualDeleteButtonsSize = addAndRemoveElements.deleteButtons.size();
        int expectedDeleteButtonSize = 20;

        Assert.assertEquals(actualDeleteButtonsSize, expectedDeleteButtonSize);

        //Verify if all "Delete" buttons are deleted or not

        for (WebElement deleteButton : addAndRemoveElements.deleteButtons) {
            deleteButton.click();
        }

        int actualDeleteButtonsSize2 = addAndRemoveElements.deleteButtons.size();
        int expectedDeleteButtonSize2 = 0;

        Assert.assertEquals(actualDeleteButtonsSize2, expectedDeleteButtonSize2);

        //NOTE: FOLLOW POM
    }

    @Test
    public void task2() {

        WindowsPage windowsPage = new WindowsPage();


        //Open https://practice.expandtesting.com/windows page
        Driver.getDriver().get("https://practice.expandtesting.com/windows");

        //Click "Click Here" link
        windowsPage.clickBtn.click();

        ArrayList<String> windows = new ArrayList<>(Driver.getDriver().getWindowHandles());

        Driver.getDriver().switchTo().window(windows.get(1));

        //Verify the header of new page is "Example of a new window"
        String expectedHeader = "Example of a new window";
        String actualHeader = windowsPage.headerOfNewPage.getText();
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void task3() {

        ContextMenu contextMenu = new ContextMenu();

        //Goto https://practice.expandtesting.com/context-menu page
        Driver.getDriver().get("https://practice.expandtesting.com/context-menu");

        //Context click in framed area
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(contextMenu.frameArea).perform();

        //Verify the text of alert is "You selected a context menu"
        Alert alert = Driver.getDriver().switchTo().alert();

        String actualAlertText = alert.getText();

        alert.accept();

        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(actualAlertText, expectedAlertText);

    }

    @Test
    public void task4() {

        //Goto https://practice.expandtesting.com/slow page
        Driver.getDriver().get("https://practice.expandtesting.com/slow");

        SlowCounter slowCounter = new SlowCounter();

        //Verify if the counter which shows seconds starts from 10 and shows each number until 1 (including 1)

        for (int i = 10; i > 0; i--) {

            String actualMessage = slowCounter.message.getText();

            Assert.assertTrue(actualMessage.contains(i + ""));

            BrowserUtility.sleep(1);
        }

        //Verify if "The slow task has finished. Thanks for waiting!" is displayed after 10 seconds
        String expectedLastMessage = "The slow task has finished. Thanks for waiting!";
        String actualLastMessage = slowCounter.message.getText();

        Assert.assertEquals(actualLastMessage, expectedLastMessage);
    }

    @Test
    public void task5() {

        //Goto https://practice.expandtesting.com/autocomplete page
        Driver.getDriver().get("https://practice.expandtesting.com/autocomplete");

        AutoComplete autoComplete = new AutoComplete();

        //Print "A" into "Country name" box and print the count of listed countries
        autoComplete.inputCountry.sendKeys("A");

        List<WebElement> countries = autoComplete.listOfCountriesStartedWithA;
        ArrayList<String> countriesString = new ArrayList<>();

        System.out.println(autoComplete.listOfCountriesStartedWithA.size());

        //Type each listed country into "Country name" box
        //and click "Submit" button and verify that the result text contains selected country

        for (String eachCountry : countriesString) {
            autoComplete.inputCountry.clear();
            autoComplete.inputCountry.sendKeys(eachCountry);
            autoComplete.submitBtn.click();

            String expectedResultText = eachCountry;
            String actualResultText = autoComplete.resultText.getText();
            Assert.assertEquals(actualResultText, expectedResultText);
        }
    }

    @Test
    public void task6() {

        //Goto https://practice.expandtesting.com/autocomplete page
        Driver.getDriver().get("https://practice.expandtesting.com/autocomplete");

        AutoComplete autoComplete = new AutoComplete();

        //Challenge (You can find and print the count of all countries)

        int countOfCountries = 0;
        for (char i = 'A'; i <= 'Z'; i++) {

            autoComplete.inputCountry.clear();
            autoComplete.inputCountry.sendKeys("" + i);
            countOfCountries += autoComplete.listOfCountriesStartedWithA.size();
        }
        System.out.println("countOfCountries = " + countOfCountries);
    }

    @Test
    public void task7() {
        //Goto https://practice.expandtesting.com/tables page
        Driver.getDriver().get("https://practice.expandtesting.com/tables");
        DynamicTable dynamicTable = new DynamicTable();

        //Click first table's "First Name" header to sort table
        dynamicTable.headerFirstName.click();

        //Verify if "First Name" column is sorted or not
        List<String> stringFirstNamesT1 = new ArrayList<>();
        List<String> stringFirstNamesT1Sorted = new ArrayList<>();

        for (WebElement element : dynamicTable.firstNamesT1) {
            stringFirstNamesT1.add(element.getText());
            stringFirstNamesT1Sorted.add(element.getText());
        }

        Collections.sort(stringFirstNamesT1Sorted);

        Assert.assertEquals(stringFirstNamesT1, stringFirstNamesT1Sorted);


        //Click second table's "Last Name" header to sort table
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,400)");
        dynamicTable.headerLastName.click();

        //Verify if "Last Name" column is sorted or not

        List<String> stringLastNamesT2 = new ArrayList<>();
        List<String> stringLastNamesT2Sorted = new ArrayList<>();

        for (WebElement element : dynamicTable.lastNamesT2) {
            stringLastNamesT2.add(element.getText());
            stringLastNamesT2Sorted.add(element.getText());
        }

        Collections.sort(stringLastNamesT2Sorted);

        Assert.assertEquals(stringLastNamesT2, stringLastNamesT2Sorted);
    }

    @Test
    public void task8() {

        //Goto https://practice.expandtesting.com/login page
        Driver.getDriver().get("https://practice.expandtesting.com/login");
        LoginPage loginPage = new LoginPage();

        //Get username and password form page (Tip:they are emphasized)
        //Enter the username into username box
        loginPage.usernameBox.sendKeys(loginPage.username.getText());

        //Enter the password into password box
        loginPage.passwordBox.sendKeys(loginPage.password.getText());

        //Click login button
        loginPage.loginBtn.click();

        //Verify that "You logged into a secure area!" message is displayed
        Assert.assertEquals(loginPage.youLoggedIntoSecureArea.getText(), "You logged into a secure area!");

        //Click "Logout" link
        loginPage.logoutLink.click();

        //Verify that "You logged out of the secure area!" message is displayed
        Assert.assertEquals(loginPage.youLoggedOutOfTheSecureArea.getText(), "You logged out of the secure area!");
    }

    @Test
    public void task9() {

        //Goto https://practice.expandtesting.com/radio-buttons page
        Driver.getDriver().get("https://practice.expandtesting.com/radio-buttons");
        RadioButtons radioButtons = new RadioButtons();

        //Select each radio button if it is selectable
        int countOfSelectable = 0;
        for (WebElement radioButton : radioButtons.radioButtons) {
            if (radioButton.isEnabled()) {
                radioButton.click();
                BrowserUtility.sleep(2);
                countOfSelectable++;
            }
        }

        //Verify that the count of selectable radio buttons is 7
        Assert.assertEquals(countOfSelectable, 7);
    }


    @Test
    public void task10() {

        //Goto https://practice.expandtesting.com/key-presses page
        Driver.getDriver().get("https://practice.expandtesting.com/key-presses");
        //Press each lowercase and uppercase letters and numbers and check for each one if it is shown in result text
        KeyPressesPage keyPressesPage = new KeyPressesPage();

        List<Character> chars = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            chars.add(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            chars.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            chars.add(i);
        }

        for (Character eachChar : chars) {

            keyPressesPage.inputBox.sendKeys(eachChar.toString());

            String expected = eachChar.toString();
            String actual = keyPressesPage.resultText.getText().replace("You entered: ", "");

            Assert.assertEquals(expected.toUpperCase(), actual);
        }
    }

    @Test
    public void task11() {

        //Goto https://practice.expandtesting.com/drag-and-drop-circles page
        Driver.getDriver().get("https://practice.expandtesting.com/drag-and-drop-circles");
        DragAndDrop dragAndDrop = new DragAndDrop();
        Actions actions = new Actions(Driver.getDriver());

        //Move to the red circle into the box
        //Move to the blue circle into the box
        //Move to the green circle into the box
        //Verify that the circles are in the order you moved them
        List<WebElement> draggables = dragAndDrop.draggableColors;

        for (int i = 0; i < draggables.size(); i++) {
            actions.dragAndDrop(draggables.get(i), dragAndDrop.grayZone).perform();
            Assert.assertEquals(dragAndDrop.dropZoneColors.get(i).getAttribute("class"), dragAndDrop.draggableColors.get(i).getAttribute("class"));
        }
    }

    @Test
    public void task12() {

        //Goto https://practice.expandtesting.com/iframe page
        Driver.getDriver().get("https://practice.expandtesting.com/iframe");
        Iframe iframe = new Iframe();

        //Get the name of video
        Driver.getDriver().switchTo().frame(iframe.frameOfVideo);
        String titleOfVideo = iframe.titleOfVideo.getText();
        Driver.getDriver().switchTo().parentFrame();

        //Clear comment area
        Driver.getDriver().switchTo().frame(iframe.frameOfComment);
        iframe.commentFields.clear();

        //Verify if it is cleared
        Assert.assertTrue(iframe.commentFields.getText().isEmpty());

        //Print $theNameOfVideo + "was wonderful!" in comment area
        iframe.commentFields.sendKeys(titleOfVideo + " was wonderful!");

        //Verify if it is printed
        Assert.assertEquals(iframe.commentFields.getText(), titleOfVideo + " was wonderful!");

        //Input a valid email into "Send updates" box
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().frame(iframe.frameOfSub);
        iframe.emailBox.sendKeys(ConfigReader.getProperties("email"));

        //Click "Subscribe" button
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        BrowserUtility.sleep(2);
        iframe.subscribeBtn.click();

        //Verify "You are now subscribed!" message occurs
        Assert.assertEquals(iframe.messageOfSub.getText(), "You are now subscribed!");
    }

    @Test
    public void task13() {

        //Goto https://practice.expandtesting.com/dynamic-table page
        Driver.getDriver().get("https://practice.expandtesting.com/dynamic-table");
        DynamicTable2 dynamicTable2 = new DynamicTable2();

        //Get the value of CPU load for chrome from table
        String valueOfCPUChromeTableText = dynamicTable2.valueOfCPUChromeTable.getText();

        //Verify if it is equals to value in the yellow label
        String valueOfCPUYellowLabelText = dynamicTable2.valueOfCPUYellowLabel.getText().split(":")[1].trim();

        Assert.assertEquals(valueOfCPUChromeTableText,valueOfCPUYellowLabelText);

        //Refresh page
        Driver.getDriver().navigate().refresh();

        //Verify again
        valueOfCPUChromeTableText = dynamicTable2.valueOfCPUChromeTable.getText();
        valueOfCPUYellowLabelText = dynamicTable2.valueOfCPUYellowLabel.getText().split(":")[1].trim();

        Assert.assertEquals(valueOfCPUChromeTableText,valueOfCPUYellowLabelText);

        //Tip:Table is dynamic
    }

}
