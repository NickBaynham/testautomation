package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickSubmit();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert Text Did Not Match!");
    }
}
