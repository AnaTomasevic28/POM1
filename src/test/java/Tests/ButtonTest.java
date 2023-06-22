package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public ButtonsPage buttonsPage;
    public JavascriptExecutor js;
    public Actions actions;
    public String doubleClickMessage;
    public String rightClickMessage;
    public String clickMessage;


    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        buttonsPage = new ButtonsPage ();
        actions = new Actions (driver);
        js = (JavascriptExecutor) driver;
        doubleClickMessage = "You have done a double click";
        rightClickMessage = "You have done a right click";
        clickMessage = "You have done a dynamic click";
        driver.get (homeURL);
    }

    @Test
    public void doubleClickOnButton(){
        homepagePage.clickOnCard (excelReader.getStringData ("CardNames", 1,0));
        sidebarPage.clickOnButton (excelReader.getStringData ("Sidebar", 5,0));
        waitForVisibility (buttonsPage.buttons.get (0));
        actions.doubleClick(buttonsPage.buttons.get (0)).perform();
        WebElement message = driver.findElement (By.id ("doubleClickMessage"));
        Assert.assertTrue (message.isDisplayed ());
        Assert.assertEquals (message.getText (), doubleClickMessage);
    }


    @Test
    public void rightClickOnButton(){
        homepagePage.clickOnCard (excelReader.getStringData ("CardNames", 1,0));
        sidebarPage.clickOnButton (excelReader.getStringData ("Sidebar", 5,0));
        waitForClickability (buttonsPage.buttons.get (1));
        actions.contextClick (buttonsPage.buttons.get (1)).perform();
        WebElement message = driver.findElement (By.id ("rightClickMessage"));
        Assert.assertTrue (message.isDisplayed ());
        Assert.assertEquals (message.getText (), rightClickMessage);
    }

    @Test
    public void clickOnButton(){
        homepagePage.clickOnCard (excelReader.getStringData ("CardNames", 1,0));
        sidebarPage.clickOnButton (excelReader.getStringData ("Sidebar", 5,0));
        buttonsPage.buttons.get (2).click ();
        WebElement message = driver.findElement (By.id ("dynamicClickMessage"));
        Assert.assertTrue (message.isDisplayed ());
        Assert.assertEquals (message.getText (), clickMessage);
    }

}
