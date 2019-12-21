package forgotpassword;

import basetest.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickLinkForgotPassword();
        forgotPasswordPage.enterEmailAddress("adams@aol.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickButtonRetrievePassword();
        assertEquals(emailSentPage.getContentText(), "Your e-mail's been sent!");
    }
}
