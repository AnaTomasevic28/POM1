package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.RadioButtonPage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public RadioButtonPage radioButtonPage;
    public JavascriptExecutor js;


    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage ();
        radioButtonPage = new RadioButtonPage ();
        js = (JavascriptExecutor) driver;
        driver.get(homeURL);
    }

    @Test
    public void clickOnYesButton(){
        homepagePage.clickOnCard (excelReader.getStringData ("CardNames", 1,0));
        sidebarPage.clickOnButton (excelReader.getStringData ("Sidebar", 3,0));
        js.executeScript ("arguments[0].click()", radioButtonPage.yesRadioButton);
        WebElement message = driver.findElement (By.className ("mt-3"));
        Assert.assertTrue (radioButtonPage.yesRadioButton.isSelected ());
        Assert.assertTrue (message.isDisplayed ());
        Assert.assertEquals (message.getText (), "You have selected Yes");
        }

    @Test
    public void clickOnImpressiveButton(){
        homepagePage.clickOnCard (excelReader.getStringData ("CardNames", 1,0));
        sidebarPage.clickOnButton (excelReader.getStringData ("Sidebar", 3,0));
        js.executeScript ("arguments[0].click()", radioButtonPage.impressiveRadioButton);
        WebElement message = driver.findElement (By.className ("mt-3"));
        Assert.assertTrue (radioButtonPage.impressiveRadioButton.isSelected ());
        Assert.assertTrue (message.isDisplayed ());
        Assert.assertEquals (message.getText (), "You have selected Impressive");
    }

    @Test
    public void clickOnNoRadioButton(){
        homepagePage.clickOnCard (excelReader.getStringData ("CardNames", 1,0));
        sidebarPage.clickOnButton (excelReader.getStringData ("Sidebar", 3,0));
        js.executeScript ("arguments[0].click()", radioButtonPage.noRadioButton);
        Assert.assertFalse (radioButtonPage.noRadioButton.isSelected ());
        boolean b = false;

        try{
           b = driver.findElement (By.className ("mt-3")).isDisplayed ();
        }
        catch (Exception e){
        }
        Assert.assertFalse (b);
    }

}



