package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.get(homeURL);
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("UsernameAndPassword", 6, 0);
        String validPassword = excelReader.getStringData("UsernameAndPassword", 6, 1);
        homepagePage.clickOnCard ("Book Store Application");
        sidebarPage.clickOnButton("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(profilePage.usernameName);
        Assert.assertTrue(profilePage.usernameName.isDisplayed());
        Assert.assertEquals(profilePage.usernameName.getText(), validUsername);

    }

    @Test(priority = 20)
    public void userCannotLogIn() {
        homepagePage.clickOnCard ("Book Store Application");
        sidebarPage.clickOnButton("Login");
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }


}
